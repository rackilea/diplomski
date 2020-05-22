public class AnalyticsModelGenerator implements FlatMapFunction<String, AnalyticsModel> {

    private final Long endDate;
    private final Calendar cal;

    public AnalyticsModelGenerator(Calendar cal, Long endDate) {
        this.cal = cal;
        this.endDate = endDate;
    }
    @Override
    public Iterable<AnalyticsModel> call(String dummyInput) throws Exception {
        return new Iterable<AnalyticsModel>() {
            @Override
            public Iterator<AnalyticsModel> iterator() {
                return new AMIterator(cal, endDate);
            }
        }
    }

    private class AMIterator implements Iterator<AnalyticsModel> {
        private final Long endDate;
        private final Calendar cal;

        public AMIterator(Calendar cal, Long endDate) {
            this.cal = cal;
            this.endDate = endDate;
        }

        @Override
        public boolean hasNext() {
            return (cal.getTimeInMillis() <= endDate);
        }

        @Override
        public AnalyticsModel next() {
            return new AnalyticsModel(time, columnName, aggrResult);
        }
    }
}