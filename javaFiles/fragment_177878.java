try {
  Configuration conf = HBaseConfiguration.create();
  Connection connection = ConnectionFactory.createConnection(conf);
  Table table = connection.getTable(TableName.valueOf("emp"));

  Put p = new Put(Bytes.toBytes("row1"));
  p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"),Bytes.toBytes("raju"));

  table.put(p);
} finally {
  table.close();
  connection.close();
}