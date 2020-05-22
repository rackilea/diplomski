public static void main(final String[] args) {
    final SparkSession sparkSession = SparkSession.builder().getOrCreate();
    final Dataset<Row> events = sparkSession.read().option("header", "true").csv("/input/events");
    events.createOrReplaceTempView("groupedevents");
    final Dataset<String> groupedEvents = sparkSession.sql("select identifier, sort_array(collect_list(struct(timestamp, struct(x, y) as properties))) as events from groupedevents group by identifier").toJSON();
    groupedEvents.write().text("/output/events");
    sparkSession.stop();
}