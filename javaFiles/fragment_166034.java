public class PassageStatistics {

    private static final Long DEFAULT_PASSAGE_COUNT = 0;
    private static final Long DEFAULT_REVENUE = 0;
    private long passageCount;
    private long revenue;

    public PassageStatistics(Long passageCount, Long revenue) {
        this.passageCount = passageCount == null ? DEFAULT_PASSAGE_COUNT : passageCount;
        this.revenue = revenue == null ? DEFAULT_REVENUE : revenue;
    }
}