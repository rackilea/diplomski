HTable table = getTable();

Get get = new Get(row);
// exclude the entire "big" column family 
get.setFilter(new FamilyFilter(CompareOp.NOT_EQUAL, new BinaryComparator(Bytes.toBytes("big"))));

Get get2 = new Get(row);
// include the "big" column family, but only retrieve the key 
FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
filterList.addFilter(new KeyOnlyFilter());
filterList.addFilter(new FamilyFilter(CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("big"))));
get2.setFilter(filterList);

List<Get> getList = new ArrayList<Get>();
getList.add(get);
getList.add(get2);
retrieveAndUseResults(table, getList);