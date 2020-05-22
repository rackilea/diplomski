@Entity(name = "LocalDateEvent")
public class LocalDateEvent {

    @Id
    private Long id;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;
}