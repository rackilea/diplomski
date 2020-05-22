CellTable<Contact> table = new CellTable<Contact>();

TextColumn<Contact> nameColumn = new TextColumn<Contact>() { /* ... */ };  
table.addColumn(nameColumn, "Name");

TextColumn<Contact> addressColumn = new TextColumn<Contact>() { /* ... */ };
table.addColumn(addressColumn, "Address");

table.setRowData( /* ... */ );