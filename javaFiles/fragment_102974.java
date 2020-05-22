/**
 * Read the data
 */
while ((line = br.readLine()) != null) {
    String[] lineSplitted = line.split(";", -1);
    Point point = Point.measurement(observedProperty)
            .tag("producerId", producerId)
            .tag("observationId", observationId)
            .time(df.parse(lineSplitted[1]).getTime(), TimeUnit.MILLISECONDS)
            .addField("value", lineSplitted[5])
            .addField("flag", lineSplitted[6])
            .build();
    influxDB.write(point);
  //  batchPoints.point(point);
}
//influxDB.write(batchPoints);