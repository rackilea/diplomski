private JScrollBar sb1 = new JScrollBar(){

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(
            super.getPreferredSize().width, ta1.getPreferredSize().height);
    }
};