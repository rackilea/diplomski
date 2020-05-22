public interface OpeningHoursRepository extends CrudRepository<OpeningHours, Long> {

@Query(value = "SELECT closing_time FROM opening_hours WHERE day = :#{#day_of_week.getValue()}", nativeQuery = true)
    public LocalTime getShopClosingTimeOn(@Param("day_of_week") DayOfWeek dayOfWeek);

     }