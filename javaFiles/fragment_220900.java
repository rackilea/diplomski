@Projection(
        name = "sorted",
        types = Person.class
)
public interface PersonProjection {

    @Value("#{@personProjectionHelper.sortedByDisabilityHistory(target.disabilityHistory)}")
    List<DisabilityHistory> getDisabilityHistory();
}