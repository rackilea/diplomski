class GuiClass {

    private DrawPanel drawPanel;

    public void createAndShowGui() {
        drawPanel = new DrawPanel();
        MyTableModel model = new MyTableModel();
        model.addTableModelListener(new TableModelListener() { // Anonymous class
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    int rows = ((TableModel)e.getSource()).getRowCount();
                    drawPanel.setNumberOfArrows(rows);
                }
            }
        });
        // rest of your GUI code here
    }
}