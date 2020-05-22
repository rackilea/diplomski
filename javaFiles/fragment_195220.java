List<Object[]> obj = query.list(); 
List<RecordSet> recordset = new ArrayList<RecordSet>(); 
for (Object[] item: obj) {
    Master master = null;
    DateRange dateRange = null;
    if (item[0] instanceof Master) {
        Master master = (Master) item[0];
        DateRange dateRange = (DateRange) item[1];
    } else if (item[0] instanceof DateRange) {
        DateRange dateRange = (DateRange) item[0];
        Master master = (Master) item[1];
    }
    RocordSet record = new RecordSet();
    record.setMaster(master);
    record.setDateRange(dateRange);
    recordset.add(record);
}