sliceQuery.setKey("your row key");

Composite startRange = new Composite();
startRange.addComponent(0, "c1",Composite.ComponentEquality.EQUAL);

Composite endRange = new Composite();
endRange.addComponent(0, "c1",Composite.ComponentEquality.GREATER_THAN_EQUAL);

sliceQuery.setRange(startRange,endRange, false, Integer.MAX_VALUE);

QueryResult<ColumnSlice<Composite, String>> result = sliceQuery.execute();
ColumnSlice<Composite, String> cs = result.get();