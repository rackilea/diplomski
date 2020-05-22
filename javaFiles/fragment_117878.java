public class NGramsTableModel extends AbstractTableModel implements TableModel {
private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
...
...
@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    ...
    //it's OK, i see this message with entered symbols
    System.out.println("setValueAt: " + aValue);
    //Use your fireXXX method
    fireNGramTableChanged();
}

@Override
public void addTableModelListener(TableModelListener l) {
    listeners.add(l);
}

@Override
public void removeTableModelListener(TableModelListener l) {
    listeners.remove(l);
}

protected void fireNGramTableChanged(){
   for(TableModelListener next : listeners){
     next.tableChanged(new TableModelEvent());
   }
}