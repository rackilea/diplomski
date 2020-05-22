// create stubbed rows
Vector<Row> rows = new Vector<Row>();
Row row = new Row();
rows.add(row);

// mock items Vector
Vector<Item> items = new Vector<>();
for (...){ // nb element to create
  Item mockedItem = Mockito.mock(Item.class);
  doReturn(rows).when(mockedItem).getRows();
  items.add(mockedItem);
}