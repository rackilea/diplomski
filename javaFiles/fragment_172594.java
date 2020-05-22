public void paint(Graphics g) {
    super.paint(g);
    g.drawString ("Foo", 70, 70);
    paint2(g);
}

public void paint2(Graphics g) {
    g.drawString ("Bar", 600, 600);
}