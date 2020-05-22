public class ReorderableTableModel extends DefaultTableModel implements Reorderable {
  public void reorder(int from, int to) {
    Object o = getDataVector().remove(from);
    getDataVector().add(to, o);
    fireTableDataChanged();
  }
}