Flowable<KeyValuePublisher> source1 = ...
Flowable<KeyValuePublisher> source2 = ...
Flowable<KeyValuePublisher> source3 = ...

Flowable.merge(
    source1.rebatchRequests(N),
    source2.rebatchRequests(N),
    source3.rebatchRequests(N)
)
.toMultimap(kvp -> kvp.key, kvp -> kvp.value)
subscribe(map -> System.out.println(map));