@Bean
  public InfluxDB influxDB(InfluxDBProperties props) {
    InfluxDB influxDB = InfluxDBFactory.connect(props.getUrl(), props.getUsername(), props.getPassword());
    influxDB.query(new Query(CREATE_DB, props.getDbName()));
    influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
    influxDB.setDatabase(props.getDbName());
    return influxDB;
  }