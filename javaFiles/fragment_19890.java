private static final int W = 640;
private static final int H = 480;
…
Display d = new Display(vis) {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }
};
d.pan(W / 2, H / 2);