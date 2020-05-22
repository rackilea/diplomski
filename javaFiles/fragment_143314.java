public class Meeting {
    private UUID id ;  // java.util.UUID.randomUUID()
    private LocalDateTime start ;
    private Recurrence recur ;  // Stores an object from your own Enum defining DAILY, WEEKLY, etc.
    private Integer limit ; // The number of times this event recurs.
}