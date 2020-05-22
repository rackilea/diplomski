// Batch 1
influxDB.enableBatch(5000, 100, TimeUnit.MILLISECONDS);
for (int j = 0; j < 5000; j++) {
   Point point = Point.measurement("cpu")
                      .addField("idle", (double) j)
                      .addField("system", 3.0 * j).build();
   influxDB.write(dbName, "autogen", point);
}
influxDB.disableBatch();

// Batch 2
// ...