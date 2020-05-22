@Entity
public class Schedule {

    @EmbeddedId
    ScheduleOwner owner;

    String description;
}