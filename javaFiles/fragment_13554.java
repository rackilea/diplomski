class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Integer.toString(avg), 75, 75);
    }

}