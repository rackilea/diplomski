public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(a);
    if(pointStart!=null && pointEnd!=null){
        g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
    }
}