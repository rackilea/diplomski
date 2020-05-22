public interface Clock {
    LocalDate today();
    LocalTime time();
    LocalDateTime now();
    long timestamp();
}