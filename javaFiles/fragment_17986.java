JTable table = new JTable(model) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(1024, 512);
    }
};
add(new JScrollPane(table));
pack();