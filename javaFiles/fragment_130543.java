class MyCanvas extends JComponent {

    public void paint(Graphics g) {
        g.fillRect(x, y, width, height);
        g.drawRect(x, y, width, height);
    }
}