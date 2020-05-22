public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    private LocalTime closingTime;

    @Column(name = "day")
    @Convert(converter = DayOfWeekIntegerConverter.class)
    private DayOfWeek day;
}