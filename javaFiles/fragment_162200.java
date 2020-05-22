public U4() {
    setBackground(Color.white);
    addMouseListener(this);
}


// ...

public void paint(Graphics g) {
    //  addMouseListener(this);
    super.paint(g); 
    g.setColor(Color.blue);
    g.drawLine(x1, y1, x2, y2);
}