interface MyGate {
    void draw(Graphics2D g2);
    void setPoint(Point p);
    Point getPoint();
    boolean contains(Point p);  
}