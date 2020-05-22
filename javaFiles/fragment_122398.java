JTable table = ...;
Object identifier = ...;
TableColumnModel model = table.getColumnModel();
boolean found = false;
for (int index = 0; index < model.getColumnCount(); index++) {
    if (model.getColumn(index).getIdentifier().equals(identifier)) {
        found = true;
        break;
    }            
}