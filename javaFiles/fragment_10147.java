public static class DatabaseMapper extends RichFlatMapFunction<Event, EncrichedEvent> {

    // Declare DB coonection and query statements

    @Override
    public void open(Configuration parameters) throws Exception {
      // Initialize Database connection
      // Prepare Query statements
    }

    @Override
    public void flatMap(Event currentEvent, Collector<EncrichedEvent> out) throws Exception {
      // look up the Database, update record, enrich event
      out.collect(enrichedEvent);        
    }
})