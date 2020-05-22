protected void paintComponent(Graphics g){
    super.paintComponent(g);
    for (int i = 0; i < recs.size(); i ++) {
        g.setColor(colors.get(i));
        g.setStroke(strokes.get(i));
        g.drawRectangle(recs);
    }
}