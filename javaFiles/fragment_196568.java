public interface OpeningHoursRepository extends CrudRepository<OpeningHours, Long> {

    @Query(value = "SELECT closingTime FROM OpeningHours WHERE day = :day_of_week")
    public LocalTime getShopClosingTimeOn(@Param("day_of_week") DayOfWeek dayOfWeek);

}