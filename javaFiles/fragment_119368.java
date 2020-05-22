stream.selectKey((key, value) -> value.getID())
    .groupByKey()
    .windowedBy(TimeWindows.of(Duration.ofSeconds(10)))
    .reduce((value1, value2) -> value2)
    .suppress(Suppressed.untilWindowCloses(unbounded())))  // like this
    .toStream()
    .peek((key, value) -> log.info("key={}, value={}", key, value.toString()))
    .to(OUTPUT_TOPIC, Produced.with(Serdes.String(), specificAvroSerde));