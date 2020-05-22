public class TopicTableModel extends AbstractTableModel {

private static final long serialVersionUID = 1L;
private int rowCount, colCount;
private String[] columnNames = {"ID", "Name", "Date", "User"};
private List<TopicData> listOfObjects;
public TopicTableModel(ArrayList<TopicData> listOfObjects) {
    this.listOfObjects = listOfObjects;
} 

@Override
public int getColumnCount() {
    return columnNames.length;
}

@Override
public int getRowCount() {
    return listOfObjects.size();
}

@Override
public String getColumnName(int col) {
    return columnNames[col];
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    TopicData data = listOfObjects.get(rowIndex);
    switch(columnIndex) {
        case 0:
            return data.getId();
        case 1:
            return data.getName();
        case 2:
            return data.getDate();
        case 3:
            return data.getUser();
    }
    return null;
}

@Override
public boolean isCellEditable(int rowIndex, int colIndex) {
    return false; //Disallow the editing of any cell
}

}