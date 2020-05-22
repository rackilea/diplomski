@Entity
@Table(name = "days")
public class Day implements Serializable {

    @ManyToOne
    @JoinColumn(name="calendar_id")
    private Calendar calendar;
}