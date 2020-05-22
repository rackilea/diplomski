kinessStream
.flatMap(...)
.mapToPair(...)
.mapPartitions(iterator -> {
    Enricher enricher = new EnricherService(...); // instantiate my service locally 
                                                  // should be able to create an instance *without* requiring DI
    for(Event event : deviceIdEvents._2) {
        enricher.enrich(event);  // this is strongly discouraged. Avoid mutable state!
    }
    return deviceIdEvents;
    // this should be a better option:
    // return iterator.map(event -> enricher.enrich(event));
 } 
})