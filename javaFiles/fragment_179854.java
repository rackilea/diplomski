public void ring(int x , int y , String color, graphics2D g2) {
    Ellipse2D.Double circle = new Ellipse2D.Double( x , y ,100,100);

    g2.setPaint(Color.getColor(color));
    g2.draw(circle);
}