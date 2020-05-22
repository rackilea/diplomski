private static final int W = 50;

private static class MyLabel extends JLabel {

    public MyLabel(String text) {
        super(text);
        this.setHorizontalAlignment(CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, super.getPreferredSize().height);
    }
}