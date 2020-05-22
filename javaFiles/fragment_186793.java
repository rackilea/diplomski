Config c = new Config();
List<String> zkServers = new ArrayList<String>();
zkServers.add("localhost");
c.put(Config.STORM_ZOOKEEPER_SERVERS, zkServers);
c.put(Config.STORM_ZOOKEEPER_PORT, 2181);
c.put(Config.STORM_ZOOKEEPER_SESSION_TIMEOUT, 30);
c.put(Config.STORM_ZOOKEEPER_CONNECTION_TIMEOUT, 30);
c.put(Config.STORM_ZOOKEEPER_RETRY_TIMES, 3);
c.put(Config.STORM_ZOOKEEPER_RETRY_INTERVAL, 5);