// Create a connection to the cluster.
HConnection connection = HConnectionManager.createConnection(Configuration);
HTableInterface table = connection.getTable("myTable");
// use table as needed, the table returned is lightweight
table.close();
// use the connection for other access to the cluster
connection.close();