import java.util.List;

public interface MeetingDAO {

    void createMeeting(Meeting meeting);

    Meeting getMeeting(long meetingId);

    void deleteMeeting(long meetingId);

    List<Meeting> getMeetings();

    void updateMeeting(Meeting meeting);
}