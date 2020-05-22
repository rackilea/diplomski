KafkaStreams streams = ... // counting words
Store queryableStoreName = ... // the queryableStoreName should be the name of the store as defined by the Materialized instance
ReadOnlyWindowStore<String,Long> localWindowStore = streams.store(queryableStoreName, QueryableStoreTypes.<String, Long>windowStore());

String key = "some-word";
long fromTime = ...;
long toTime = ...;
WindowStoreIterator<Long> countForWordsForWindows = localWindowStore.fetch(key, timeFrom, timeTo); // key must be local (application state is shared over all running Kafka Streams instances)