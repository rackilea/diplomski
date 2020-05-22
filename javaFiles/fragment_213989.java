public class RoomTableModel extends AbstractTableModel {

    private Room[][] reservations;

    public RoomTableModel(Room[][] reservations) {
        this.reservations = reservations;
    }

    @Override
    public int getRowCount() {
        return reservations.length;
    }

    @Override
    public int getColumnCount() {
        return reservations[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return reservations[rowIndex][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Room.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue instanceof Room) {
            Room room = (Room) aValue;
            reservations[rowIndex][columnIndex] = room;
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

}