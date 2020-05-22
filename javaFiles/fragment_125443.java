public void paint (Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    if (yourCondition) {
        g2.draw(new Rectangle2D.Double(x, y, rectwidth, rectheight));
    }
}