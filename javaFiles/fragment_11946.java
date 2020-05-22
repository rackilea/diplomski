public class DataProcessor {
    private ServiceOne serviceOne;
    private ServiceTwo serviceTwo;

    public DataProcessor(ServiceOne serviceOne, ServiceTwo serviceTwo) {
        this.serviceOne = serviceOne;
        this.serviceTwo = serviceTwo;
    }

    public void processAll(List<String> allValues) {
        List<String> copy = new ArrayList<String>(allValues);
        for (String value : copy) {
            this.serviceOne.preProcessData(value);
            this.serviceTwo.completeTransaction(value);
        }
    }
}