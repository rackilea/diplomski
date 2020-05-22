Configuration conf = HBaseConfiguration.create();
HBaseAdmin hbase = new HBaseAdmin(conf);
HTableDescriptor desc = new HTableDescriptor("test_table");
HColumnDescriptor cf = new HColumnDescriptor("cf".getBytes());
desc.addFamily(cf);
hbase.createTable(desc);