MultigetSliceCounterQuery<String, String> query=HFactory.createMultigetSliceCounterQuery(keyspace, se, se);
query.setColumnFamily("MyCounters").setKeys(list).setRange(null, null, false, 3);
CounterRows<String,String> resultRows1 = query.execute().get();

for (CounterRow<String, String> row : resultRows1) {
    System.out.println("Row Key "+ row.getKey());
    for (HCounterColumn<String> col : row.getColumnSlice().getColumns())
        System.out.println("column Name "+col.getName()+"column value "+col.getValue());
    }
}