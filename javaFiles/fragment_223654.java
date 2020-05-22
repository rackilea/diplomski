public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPT_ID", columnDefinition = "integer")
    private Long apptId;

    ...

    @OneToMany(targetEntity = ApptReminder.class, mappedBy = "appointment", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<ApptReminder> apptReminders = new ArrayList<>();
}