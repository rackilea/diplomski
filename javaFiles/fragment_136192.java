transient Enricher enricher = applicationContext.getBean(Enricher.class);
...stream setup...
.foreachRDD(rdd -> {
     Event[] events = rdd.collect(); // All data is sent to the driver. This is a bottleneck
     Events[] enrichedEvents = events.map(event -> 
         enricher.enrich(event));  // suggesting to use a map function instead of mutating in-place. The mutation used in the question would work as well. 
     // do something with enrichedEvents 

 }