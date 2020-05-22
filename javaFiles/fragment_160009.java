// get the hbase config
Configuration config = HBaseConfiguration.create();

// specify which table you want to use
HTable table = new HTable(config, "mytable");
// add a row to your table
Put p = new Put(Bytes.toBytes("myrow"));    
// specify the column family, column qualifier and column value
p.add(Bytes.toBytes("myfamily"), Bytes.toBytes("myqualifier"), Bytes.toBytes("myvalue"));
// commit to your table
table.put(p);

// define which row you want to get 
Get g = new Get(Bytes.toBytes("myrow"));
// get your row
Result r = table.get(g);
// choose what you want to extract from your row
byte[] value = r.getValue(Bytes.toBytes("myfamily"), Bytes.toBytes("myqualifier"));
// convert to a string
System.out.println("GET: " + Bytes.toString(value)); 

// do a scan operation
Scan s = new Scan();
s.addColumn(Bytes.toBytes("myfamily"), Bytes.toBytes("myqualifier"));
ResultScanner scanner = table.getScanner(s);