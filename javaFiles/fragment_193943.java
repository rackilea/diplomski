JPanel scrollContentPane = new JPanel() {
    // this is important never return this dimension always make a copy
    private final Dimension d = new Dimension(700, 700);

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(d);
    }
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(d);
    }
    @Override
    public Dimension getMaximumSize() {
        return new Dimension(d);
    }
};