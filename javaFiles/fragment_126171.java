KStream<String, Long> clicks = builder.<String, String>stream("clicks")
    .groupByKey().windowedBy(TimeWindows.of(Duration.ofSeconds(60)).grace(Duration.ofSeconds(1)))
    .count(Materialized.with(Serdes.String(), Serdes.Long()))
    .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
    .toStream().map((key, value) -> new KeyValue<>(key.key(), value));

KTable<String, Long> userPrefs = builder.<String, Long>table(
    "user-prefs",
    Consumed.with(Serdes.String(), Serdes.Long())
);

clicks.join(
    userPrefs,
    (userClicks, minUserClicksNumber) -> userClicks >= minUserClicksNumber,
    Joined.with(Serdes.String(), Serdes.Long(), Serdes.Long())
)
    .filter((userName, isSufficientNumberOfClick) -> isSufficientNumberOfClick)
    .map(((key, value) -> new KeyValue<>(key, key)))
    .to("output", Produced.with(Serdes.String(), Serdes.String()));