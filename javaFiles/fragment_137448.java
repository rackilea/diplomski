import java.util.Properties;

import net.sf.ehcache.distribution.RMICacheReplicatorFactory;
import net.sf.ehcache.util.PropertyUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cgi.itd.customComponents.ITDPropertyPlaceholderConfigurer;
import com.cgi.itd.utils.ITDApplicationConstants;

/**
 * Custom handler for RMI replicator factory
 * @author himanshu.agrawal
 *
 */
public class ItdRMICacheReplicatorFactory extends RMICacheReplicatorFactory {
    Log log = LogFactory.getLog(ItdRMICacheReplicatorFactory.class);

    public ItdRMICacheReplicatorFactory() {
        log.info("ItdRMICacheReplicatorFactory constructor.");
    }

    /**
     * Extracts the value of asynchronousReplicationIntervalMillis. Sets it to 1000ms if
     * either not set or there is a problem parsing the number
     * @param properties
     */
    @Override
    protected int extractReplicationIntervalMilis(Properties properties) {
        int asynchronousReplicationIntervalMillis;
        String asynchronousReplicationIntervalMillisString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.ASYNCHRONOUS_REPLICATION_INTERVAL_MILLIS);
        if (asynchronousReplicationIntervalMillisString != null) {
            try {
                int asynchronousReplicationIntervalMillisCandidate =
                        Integer.parseInt(asynchronousReplicationIntervalMillisString);
                if (asynchronousReplicationIntervalMillisCandidate < ITDApplicationConstants.MINIMUM_REASONABLE_INTERVAL) {
                    log.debug("Trying to set the asynchronousReplicationIntervalMillis to an unreasonable number." +
                            " Using the default instead.");
                    asynchronousReplicationIntervalMillis = DEFAULT_ASYNCHRONOUS_REPLICATION_INTERVAL_MILLIS;
                } else {
                    asynchronousReplicationIntervalMillis = asynchronousReplicationIntervalMillisCandidate;
                }
            } catch (NumberFormatException e) {
                log.warn("Number format exception trying to set asynchronousReplicationIntervalMillis. " +
                        "Using the default instead. String value was: '" + asynchronousReplicationIntervalMillisString + "'");
                asynchronousReplicationIntervalMillis = DEFAULT_ASYNCHRONOUS_REPLICATION_INTERVAL_MILLIS;
            }
        } else {
            asynchronousReplicationIntervalMillis = DEFAULT_ASYNCHRONOUS_REPLICATION_INTERVAL_MILLIS;
        }
        log.debug("Extracted asynchronousReplicationIntervalMillis = " + asynchronousReplicationIntervalMillis);
        return asynchronousReplicationIntervalMillis;
    }

    /**
     * Extracts the value of replicateAsynchronously from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicateAsynchronously(Properties properties) {
        boolean replicateAsynchronously;
        String replicateAsynchronouslyString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_ASYNCHRONOUSLY);
        if (replicateAsynchronouslyString != null) {
            replicateAsynchronously = PropertyUtil.parseBoolean(replicateAsynchronouslyString);
        } else {
            replicateAsynchronously = true;
        }
        log.debug("Extracted replicateAsynchronously = " + replicateAsynchronously);
        return replicateAsynchronously;
    }

    /**
     * Extracts the value of replicateRemovals from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicateRemovals(Properties properties) {
        boolean replicateRemovals;
        String replicateRemovalsString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_REMOVALS);
        if (replicateRemovalsString != null) {
            replicateRemovals = PropertyUtil.parseBoolean(replicateRemovalsString);
        } else {
            replicateRemovals = true;
        }
        log.debug("Extracted replicateRemovals = " + replicateRemovals);
        return replicateRemovals;
    }

    /**
     * Extracts the value of replicateUpdatesViaCopy from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicateUpdatesViaCopy(Properties properties) {
        boolean replicateUpdatesViaCopy;
        String replicateUpdatesViaCopyString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_UPDATES_VIA_COPY);
        if (replicateUpdatesViaCopyString != null) {
            replicateUpdatesViaCopy = PropertyUtil.parseBoolean(replicateUpdatesViaCopyString);
        } else {
            replicateUpdatesViaCopy = true;
        }
        log.debug("Extracted replicateUpdatesViaCopy = " + replicateUpdatesViaCopy);
        return replicateUpdatesViaCopy;
    }

    /**
     * Extracts the value of replicatePutsViaCopy from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicatePutsViaCopy(Properties properties) {
        boolean replicatePutsViaCopy;
        String replicatePutsViaCopyString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_PUTS_VIA_COPY);
        if (replicatePutsViaCopyString != null) {
            replicatePutsViaCopy = PropertyUtil.parseBoolean(replicatePutsViaCopyString);
        } else {
            replicatePutsViaCopy = true;
        }
        log.debug("Extracted replicatePutsViaCopy = " + replicatePutsViaCopy);
        return replicatePutsViaCopy;
    }

    /**
     * Extracts the value of replicateUpdates from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicateUpdates(Properties properties) {
        boolean replicateUpdates;
        String replicateUpdatesString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_UPDATES);
        if (replicateUpdatesString != null) {
            replicateUpdates = PropertyUtil.parseBoolean(replicateUpdatesString);
        } else {
            replicateUpdates = true;
        }
        log.debug("Extracted replicateUpdates = " + replicateUpdates);
        return replicateUpdates;
    }

    /**
     * Extracts the value of replicatePuts from the properties
     * @param properties
     */
    @Override
    protected boolean extractReplicatePuts(Properties properties) {
        boolean replicatePuts;
        String replicatePutsString = ITDPropertyPlaceholderConfigurer.getPropertiesMap().get(ITDApplicationConstants.REPLICATE_PUTS);
        if (replicatePutsString != null) {
            replicatePuts = PropertyUtil.parseBoolean(replicatePutsString);
        } else {
            replicatePuts = true;
        }
        log.debug("Extracted replicatePuts = " + replicatePuts);
        return replicatePuts;
    }

}