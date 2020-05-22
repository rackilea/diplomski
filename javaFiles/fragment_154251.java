final JTable table;
// ...
table.addMouseListener(new MouseAdapter() {
    @Override public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2)
            System.out.println("Current row index: " + table.getSelectedRow());
    }
});