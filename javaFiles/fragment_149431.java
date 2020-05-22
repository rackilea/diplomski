import java.time.*;
import java.time.format.DateTimeFormatter;

// records start and end times for one direction
public class RecordedTrack {

    public LocalTime start;
    public LocalTime end;

    public RecordedTrack (LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    // accept String times in "HH:MM:SS" format 
    public RecordedTrack (String start, String end) {
        this(
            LocalTime.parse(start, DateTimeFormatter.ISO_LOCAL_TIME),
            LocalTime.parse(end, DateTimeFormatter.ISO_LOCAL_TIME));
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }

    // return String times in "MM:SS" format 
    public String getDurationStr () {
        long seconds = getDuration().getSeconds();
        return String.format("%02d:%02d", (seconds % 3600) / 60, seconds % 60);
    }
}