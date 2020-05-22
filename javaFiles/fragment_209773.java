private final Map<Files, String> list = new LinkedHashMap<Files,String>();

class MyTableModel extends AbstractTableModel {

private String[] columnNames = {"File","Duration","Status"};

public void addElement(String addfile,String addurr,String addstatus, String addpath) {             
Files f = new Files(addfile, addurr, addstatus);                
list.put(f, addpath); // edit
fireTableRowsInserted(list.size()-1, list.size()-1);   
}

@Override
public int getColumnCount() {
return columnNames.length;
}

@Override
public int getRowCount() {
return list.size();
}

@Override
public String getColumnName(int col) {
return columnNames[col];
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {

List<Entry<Files,String>> randAccess = new ArrayList<Entry<Files,String>>(list.entrySet());

switch (columnIndex) {
case 0:
return randAccess.get(rowIndex).getKey().getfiles();
case 1:
return randAccess.get(rowIndex).getKey().getduration();
case 2:
return randAccess.get(rowIndex).getKey().getstatus();
default:
throw new IndexOutOfBoundsException();
        }
    }
}