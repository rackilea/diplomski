import java.time.Duration;
import java.time.Instant;
.
.
.
@Override
final Validator < String > validator = new StringValidator() {
    public TemporalAmount getTimeToLive() {
        return Duration.ofSeconds(Instant.MAX.getEpochSecond());
    }
};