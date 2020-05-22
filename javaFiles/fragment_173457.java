public void tableChanged(TableModelEvent e) {
    TableModel model = (TableModel)e.getSource();
    Object data = model.getValueAt(e.getRow(), e.getColumn());

    //do something
}