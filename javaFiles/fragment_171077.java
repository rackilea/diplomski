JTable table = new JTable() {
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(300, 300);
    }
};