stream.keyBy(new KeySelector<Event, Integer>() {
    @Override
    public Integer getKey(Event value) throws Exception {
        return value.nodeId;
    }
}).window(EventTimeSessionWindows.withGap(Time.seconds(60)))
  .apply(new ReduceFunction<LogRow>(), new WindowFunction<LogRow, Object, Integer, TimeWindow>())