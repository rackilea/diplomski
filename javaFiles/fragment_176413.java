SingleColumnValueFilter filter = new SingleColumnValueFilter(
   Bytes.toBytes("columnfamily"),
   Bytes.toBytes("storenumber"),
   CompareFilter.CompareOp.NOT_EQUAL,
   Bytes.toBytes(15)
);
filter.setFilterIfMissing(true);
Scan scan = new Scan(
   Bytes.toBytes("20110103-1"),
   Bytes.toBytes("20110105-1")
);
scan.setFilter(filter);