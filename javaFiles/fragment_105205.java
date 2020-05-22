table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent event) {
        int row = table.rowAtPoint(event.getPoint());
        int column = table.columnAtPoint(event.getPoint());
        if (row >= 0 && column >= 0) {
            // Cell has been clicked
        }
    }
});