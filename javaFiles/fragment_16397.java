@Entity(name = "CalendarEvent")
@Table
public static class CalendarEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ElementCollection
    private final List<Integer> mailingCodes = new ArrayList<>();

}

public static class MailingCode {
    private Integer id;

    public MailingCode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}