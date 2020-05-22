stream.groupByKey().aggregate(Diff::new, new Aggregator<String, Double, Diff>() {

        @Override
        public Diff apply(String key, Double newValue, Diff aggregate) {
            Double difference = newValue - aggregate.getLastValue();
            aggregate.setDifference(difference);
            aggregate.setLastValue(newValue);
            return aggregate;
        }
        }).mapValues(new ValueMapper<Diff, Double>() {

        @Override
        public Double apply(Diff value) {
            return value.getDifference();
        }

    }).toStream().to("diff");