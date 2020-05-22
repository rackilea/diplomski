JPanel panel = new JPanel() {

    @Override
    public Dimension getPreferredSize() {

        int h = super.getPreferredSize().height;
        int w = getParent().getSize().width;
        return new Dimension(w, h);
    }
};