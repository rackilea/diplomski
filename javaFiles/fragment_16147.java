formContent.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!table.contains(e.getPoint())) { // contains(Point point) method is inherited from java.awt.Component
            table.clearSelection();
        }
    }            
});