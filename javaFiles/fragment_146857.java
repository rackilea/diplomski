public class TableModelRowStorage 
    // extends AbstractBean // this is a bean convenience lass  of several binding frameworks
                            // but simple to implement directly  
     implements TableModelListener {

    private int rowCount;

    public TableModelRowStorage(TableModel model) {
        model.addTableModelListener(this);
        this.rowCount = model.getRowCount();
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        if (((TableModel) e.getSource()).getRowCount() != rowCount) {
            int old = rowCount;
            rowCount = ((TableModel) e.getSource()).getRowCount();
            doStuff(old, rowCount);
        }

    }

    protected void doStuff(int oldRowCount, int newRowCount) {
        // here goes what you want to do - all in pseudo-code
        // either directly configuring a label/start timer
        label.setText("RowCount: " + newRowCount);
        label.setForeground(newRowCount - oldRowCount > 0 ? Color.GREEN : Color.RED);
        timer.start();

        // or indirectly by firing a propertyChange
        firePropertyChange("rowCount", oldRowCount, newRowCount);
    }

}