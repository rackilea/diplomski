HTableManager hTableManager = htableManager.getInstance();
HTableInterface hTable = hTableManager.getHTable("yourTableName");
...
// Work with the hTable instance
...
// A call to the close method returns it to the pool
hTable.close();