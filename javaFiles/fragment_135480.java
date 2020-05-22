String columnName = "Column X";
model.addColumn( columnName );

//  AutoCreate is turned off so create table column here

TableColumn column = new TableColumn( table.getColumnCount() );
column.setHeaderValue( columnNamer );
table.addColumn( column );