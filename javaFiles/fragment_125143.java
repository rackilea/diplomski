JavaDStream<EventLog> lines = messages.map(new Function<Tuple2<String, EventLog>, EventLog>() {
  @Override
  public EventLog call(Tuple2<String, EventLog> tuple2) {
    return tuple2._2();
  }
});