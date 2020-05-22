public PolygonPanel(){
    p = new Polygon();
    p.addPoint(10, 10);
    p.addPoint(100,50);
    p.addPoint(50,100);
    addMouseListener(this);
    this.setFocusable(true);
    this.addKeyListener(new MKeyListener());
}