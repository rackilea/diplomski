public class MyCellTable extends CellTable<Contact>{
    public MyCellTable(String col1, String col2){
        TextColumn<Contact> nameColumn = new TextColumn<Contact>() { /* ... */ };  
        table.addColumn(nameColumn, col1);

        TextColumn<Contact> addressColumn = new TextColumn<Contact>() { /* ... */ };
        table.addColumn(addressColumn, col2);
    }
}