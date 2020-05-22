KTable<String, ArrayList<TimeOff>> newStore = source.groupBy((k, v) -> v.getEmployeeId())
        .aggregate(ArrayList::new,
                (key, value, aggregate) -> {
                    aggregate.add(value);
                    return aggregate;
                }, Materialized.<String, ArrayList<TimeOff>, KeyValueStore<Bytes, byte[]>>as("NewStore").withValueSerde(new TimeOffListSerde(new TimeOffSerde())));