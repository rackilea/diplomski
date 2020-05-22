private static Collector<InputRecord, ?, Collection<OutputRecord>> toOutputRecords() {
    class Acc {

        Map<String, OutputRecord> map = new HashMap<>();

        void add(InputRecord elem) {
            String value = elem.getName();
            // constructor without fieldC since you compute it at the end
            OutputRecord record = new OutputRecord(value, elem.getFieldA(), elem.getFieldB());
            mergeIntoMap(map, value, record);
        }

        Acc merge(Acc right) {
            Map<String, OutputRecord> leftMap = map;
            Map<String, OutputRecord> rightMap = right.map;

            for (Entry<String, OutputRecord> entry : rightMap.entrySet()) {
                mergeIntoMap(leftMap, entry.getKey(), entry.getValue());
            }
            return this;
        }

        private void mergeIntoMap(Map<String, OutputRecord> map, String value, OutputRecord record) {

            map.merge(value, record, (left, right) -> {
                left.setSumOfFieldA(left.getSumOfFieldA() + right.getSumOfFieldA());
                left.setSumOfFieldB(left.getSumOfFieldB().add(right.getSumOfFieldB()));

                return left;
            });
        }

        public Collection<OutputRecord> finisher() {
            for (Entry<String, OutputRecord> e : map.entrySet()) {
                OutputRecord output = e.getValue();
                output.setFieldC(output.getSumOfFieldB().multiply(BigDecimal.valueOf(output.getSumOfFieldA())));
            }
            return map.values();
        }

    }
    return Collector.of(Acc::new, Acc::add, Acc::merge, Acc::finisher);
}