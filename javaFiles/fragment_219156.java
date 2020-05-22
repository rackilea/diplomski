JComboBox combo = new JComboBox(new String[] { "A", "B", "C", "D" });
combo.setRenderer(new DefaultListCellRenderer() {
    public void paint(Graphics g) {
        setBackground(Color.YELLOW);
        setForeground(Color.RED);
        super.paint(g);
    }
});