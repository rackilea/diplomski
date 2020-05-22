DataSet<LogPojo> logSet = env.fromCollection(logs);
// map LogPojo to a Tuple1<Double> 
//   (Flink's built-in aggregation functions work only on Tuple types)
DataSet<Tuple1<Double>> values = logSet.map(new MapFunction<LogPojo, Tuple1<Double>>() {
    @Override
    public Tuple1<Double> map(LogPojo l) throws Exception {
      return new Tuple1<>(l.value);
    }
  });
// fetch the min value (at position 0 in the Tuple)
List<Tuple1<Double>> c = values.min(0).collect();
// get the first field of the Tuple
Double minVal = c.get(0).f0;