class MyPanel extends JPanel {
    private RectangleModel model;

    public MyPanel(RectangleModel model) {
        this.model = model;
        this.setPreferredSize(new Dimension(300, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);
    }}
}