Configuration conf = HBaseConfiguration.create();
    HTable table = new HTable(conf, "t1");
    Scan s = new Scan ();
    RegexStringComparator keyRegEx = new RegexStringComparator(".*tom.*");
    RowFilter rowFilter = new RowFilter(CompareOp.EQUAL, new  RegexStringComparator(".*tom.*"));
    s.setFilter(rowFilter);
    ResultScanner scanner = table.getScanner(s);
    Iterator<Result> it = scanner.iterator();
    while(it.hasNext()){
        // ... your code ...

}