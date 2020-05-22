JButton blueKnapp = new JButton()
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBorderPainted(this.hasFocus());
    }
};

blueKnapp.addActionListener((evt) -> {
    // set the border to either black or blue randomly.
    // replace this with your "color picker color" probably.
    blueKnapp.setBorder(new LineBorder(Math.random() < 0.5 ? Color.BLACK : Color.BLUE, 3));
});