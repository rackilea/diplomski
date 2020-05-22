public static Collector<MonthlyTransaction, ?, Statistics> withStatistics() {
    class Acc {
        long sum = 0;
        long maxCount = Long.MIN_VALUE;
        String dayWithMaxCount;

        void accumulate(MonthlyTransaction transaction) {
            sum += transaction.getCount();
            if (transaction.getCount() > maxCount) {
                maxCount = transaction.getCount();
                dayWithMaxCount = transaction.getDay();
            }
        }

        Acc merge(Acc another) {
            sum += another.sum;
            if (another.maxCount > maxCount) {
                maxCount = another.maxCount;
                dayWithMaxCount = another.dayWithMaxCount;
            }
            return this;
        }

        Statistics finish() {
            return new Statistics(dayWithMaxCount, sum);
        }
    }
    return Collector.of(Acc::new, Acc::accumulate, Acc::merge, Acc::finish);
}