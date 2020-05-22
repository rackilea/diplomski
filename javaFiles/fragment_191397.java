private static class EventTableModelFormat implements AdvancedTableFormat<Item> {
    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int i) {
        return Columns.values()[i].name;
    }

    @Override
    public Object getColumnValue(Item item, int i) {
        return item.amount;
    }

    @Override
    public Class getColumnClass(int column) {
        return Columns.values()[column].type;
    }

    @Override
    public Comparator getColumnComparator(int column) {
        return null;
    }
}