public CassandraHostConfigurator(String hosts) {
    this.hosts = hosts;
  }

  ...

  String[] hostVals = hosts.split(",");

  CassandraHost[] cassandraHosts = new CassandraHost[hostVals.length];
  ...