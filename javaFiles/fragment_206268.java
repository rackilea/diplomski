public class MThresholds {

    private static class NoIntersectionComparator implements Comparator<MThresholds> {
        @Override
        public int compare(MThresholds o1, MThresholds o2) {
            if (o1.contains(o2)) {
                return 1;
            }

            if (o2.contains(o1)) {
                return -1;
            }

            throw new IllegalStateException("Thresholds overlap");
        }
    }

    private final Double threshold_low;
    private final Double threshold_high;

    public MThresholds(Double thresholdLow, Double thresholdHigh) {
        this.threshold_low = thresholdLow;
        this.threshold_high = thresholdHigh;
    }

    public boolean contains(MThresholds that) {
        return that.threshold_low >= threshold_low && that.threshold_high <= threshold_high;
    }

    public static void main(String[] args) throws Exception {
        List<MThresholds> thresholdsList = new ArrayList<>();
        thresholdsList.add(new MThresholds(42.0, 48.0));
        thresholdsList.add(new MThresholds(30.0, 60.0));
        thresholdsList.add(new MThresholds(20.0, 70.0));
        thresholdsList.add(new MThresholds(40.0, 50.0));
        thresholdsList.add(new MThresholds(10.0, 80.0));
        thresholdsList.sort(new NoIntersectionComparator().reversed());
    }
}