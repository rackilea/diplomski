@Configuration
public class InfluxDBConfiguration {

  @Bean
  public InfluxDB influxDB() {
    InfluxDB influxDB = InfluxDBFactory.connect(URL, USERNAME, PWD);
    influxDB.query(new Query(CREATE_DB, DB_NAME));
    influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
    influxDB.setDatabase(DB_NAME);
    return influxDB;
  }

  @Bean
  public InfluxDBAdapter influxDBAdapter(InfluxDB influxDB) {
    return new InfluxDBAdapter(influxDB);
  }
}