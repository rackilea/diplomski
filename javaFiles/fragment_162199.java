public U4() {
    setBackground(Color.white);
}


// ...

public void paint(Graphics g) {
    addMouseListener(this);
    g.setColor(Color.blue);
    g.drawLine(x1, y1, x2, y2);
}