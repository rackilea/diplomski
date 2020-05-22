import org.bson.BsonDocument;
import org.bson.BsonInvalidOperationException;
import org.bson.BsonNumber;
import org.bson.BsonValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MongoReplicaSetStatusLogger {
    private static final Logger logger = LoggerFactory.getLogger(MongoReplicaSetStatusLogger.class);

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss,SSSZ");

    private static final String DEFAULT_VALUE = "UNKNOWN";
    private static final String MEMBERS = "members";

    public void report(BsonDocument replicasetStatusDocument) {
        if (hasMembers(replicasetStatusDocument)) {
            replicasetStatusDocument.getArray(MEMBERS).stream()
                    .filter(BsonValue::isDocument)
                    .map(memberDocument -> (BsonDocument) memberDocument)
                    .forEach(memberDocument -> logMemberDocument(memberDocument));
        } else {
            logger.warn("The replicaset status document does not contain a '{}' attributes, perhaps there has been " +
                    "a MongoDB upgrade and the format has changed!", MEMBERS);
        }
    }

    private boolean hasMembers(BsonDocument replicasetStatusDocument) {
        return replicasetStatusDocument.containsKey(MEMBERS) && replicasetStatusDocument.get(MEMBERS).isArray();
    }

    private void logMemberDocument(BsonDocument memberDocument) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(logAttribute("node", getStringValue(memberDocument, "name")))
                .append(logAttribute("health", getNumericValue(memberDocument, "health")))
                .append(logAttribute("state", getStringValue(memberDocument, "stateStr")))
                .append(logAttribute("uptime(s)", getNumericValue(memberDocument, "uptime")))
                .append(logAttribute("lastOptime", getDateTimeValue(memberDocument, "optimeDate")))
                .append(logAttribute("lastHeartbeat", getDateTimeValue(memberDocument, "lastHeartbeat")))
                .append(logAttribute("lastHeartbeatRecv", getDateTimeValue(memberDocument, "lastHeartbeatRecv")))
                .append(logAttribute("ping(ms)", getNumericValue(memberDocument, "pingMs")))
                .append(logAttribute("replicationLag(s)", getReplicationLag(memberDocument)));

        logger.error(stringBuilder.toString());
    }

    private String logAttribute(String key, Optional<String> value) {
        return new StringBuilder(key).append("=").append(value.orElse(DEFAULT_VALUE)).append("|").toString();
    }

    private Optional<String> getStringValue(BsonDocument memberDocument, String key) {
        if (memberDocument.containsKey(key)) {
            try {
                return Optional.of(memberDocument.getString(key).getValue().toUpperCase());
            } catch (BsonInvalidOperationException e) {
                logger.warn("Exception reading: {} from replicaset status document, message: {}.", key, e.getMessage());
            }
        }
        return Optional.empty();
    }

    private Optional<String> getNumericValue(BsonDocument memberDocument, String key) {
        if (memberDocument.containsKey(key)) {
            BsonNumber bsonNumber = memberDocument.getNumber(key);
            if (bsonNumber.isInt32()) {
                return Optional.of(Integer.toString(bsonNumber.intValue()));
            } else if (bsonNumber.isInt64()) {
                return Optional.of(Long.toString(bsonNumber.longValue()));
            } else if (bsonNumber.isDouble()) {
                return Optional.of(Double.toString(bsonNumber.doubleValue()));
            }
        }
        return Optional.empty();
    }

    private Optional<String> getDateTimeValue(BsonDocument memberDocument, String key) {
        if (memberDocument.containsKey(key)) {
            try {
                return Optional.of(dateFormatter.format(new Date(memberDocument.getDateTime(key).getValue())));
            } catch (BsonInvalidOperationException e) {
                logger.warn("Exception reading: {} from replicaset status document due to: {}!", key, e.getMessage());
            }
        }
        return Optional.empty();
    }

    private Optional<String> getReplicationLag(BsonDocument memberDocument) {
        if (memberDocument.containsKey("optimeDate") && memberDocument.containsKey("lastHeartbeat")) {
            try {
                long optimeDate = memberDocument.getDateTime("optimeDate").getValue();
                long lastHeartbeat = memberDocument.getDateTime("lastHeartbeat").getValue();
                long replicationLag = lastHeartbeat - optimeDate;
                return Optional.of(Long.toString(replicationLag));
            } catch (BsonInvalidOperationException e) {
                logger.warn("Exception reading 'optimeDate' or 'lastHeartbeat' from replicaset status document due to: {}!", e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.warn("Exception calculating the replication lag due to: {}!", e.getMessage());
            }
        }
        return Optional.empty();
    }
}