class EntityModel extends AbstractTableModel {

    public EntityModel(List<List<Entity>> data) {
        this.data = data;
    }

    List<List<Entity>> data;

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return data.get(0).size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        List list = data.get(row);
        return list.get(col);
    }