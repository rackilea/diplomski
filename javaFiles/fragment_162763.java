import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ext.JodaSerializers.DateTimeSerializer;
import org.joda.time.DateTime;

public class ConfigValues {

    private final Boolean valueBit;
    private final Integer valueInt;
    private final Double valueFloat;
    private final DateTime valueDate;
    private final DateTime timestamp;
    private final String changedBy;

    @JsonCreator
    public ConfigValues(
        @JsonProperty("valueBit") Boolean valueBit,
        @JsonProperty("valueInt") Integer valueInt,
        @JsonProperty("valueFloat") Double valueFloat,
        @JsonSerialize(using = DateTimeSerializer.class) @JsonProperty("valueDate") DateTime valueDate,
        @JsonSerialize(using = DateTimeSerializer.class) @JsonProperty("timestamp") DateTime timestamp,
        @JsonProperty("changedBy") String changedBy) {

    this.valueBit = valueBit;
    this.valueInt = valueInt;
    this.valueFloat = valueFloat;
    this.valueDate = valueDate;
    this.timestamp = timestamp;
    this.changedBy = changedBy;
    }

    final static ConfigValues defaultConfig = new ConfigValues(false, 0, 0.0, null, null, null);

    public Boolean getValueBit() {
    return valueBit;
    }

    public Integer getValueInt() {
    return valueInt;
    }

    public Double getValueFloat() {
    return valueFloat;
    }

    public DateTime getValueDate() {
    return valueDate;
    }

    public DateTime getTimestamp() {
    return timestamp;
    }

    public String getChangedBy() {
    return changedBy;
    }
}