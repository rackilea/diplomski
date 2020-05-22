Configuration conf = HBaseConfiguration.create();
     conf.set("hbase.master","121.33.6.94:60000");
     Configuration config = HBaseConfiguration.create();
     config.set("hbase.zookeeper.quorum", "121.33.6.94");
     config.set("hbase.zookeeper.property.clientPort", "2181");
     config.set("hbase.master", "121.33.6.94:60000");
     config.set("zookeeper.znode.parent", "/hbase-unsecure");