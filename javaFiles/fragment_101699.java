@Entity(name = "OffsetDateTimeEvent")
public static class OffsetDateTimeEvent {

    @Id
    private Long id;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private OffsetDateTime startDate;
}