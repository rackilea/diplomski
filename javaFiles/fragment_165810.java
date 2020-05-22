class OrGate implements MyGate {
    private Path2D path; 
    private Point point = new Point(0, 0); // initial Point

    public OrGate() {
        // initialize the Path2D and give it a winding rule
        path = new Path2D.Double(Path2D.WIND_EVEN_ODD);

        // lots of "magic" numbers below, a code design "smell"
        // better to not do this. Perhaps have a data file to hold
        // this information, and have it read on program startup
        int preX = 15;
        int preY = 0;
        int x1Points[] = { preX, preX + 50, preX + 60, preX + 70, preX + 80, preX + 70, preX + 60,
                preX + 50, preX, preX + 10, preX + 20, preX + 30, preX + 20, preX + 10, preX };
        int y1Points[] = { preY, preY, preY + 5, preY + 15, preY + 30, preY + 45, preY + 55,
                preY + 60, preY + 60, preY + 55, preY + 45, preY + 30, preY + 15, preY + 5, preY };
        path.moveTo(preX - 15, preY + 15);
        path.lineTo(preX + 20, preY + 15);
        path.moveTo(preX - 15, preY + 45);
        path.lineTo(preX + 20, preY + 45);
        path.moveTo(preX, preY);

        for (int index = 1; index < x1Points.length; index++) {
            path.lineTo(x1Points[index], y1Points[index]);
        }
        path.closePath();
    }

    @Override
    public void draw(Graphics2D g2) {
        // simple method that leverages the Path2D path object
        g2.draw(path);
    }

    @Override
    public boolean contains(Point p) {
        // simple method that leverages the Path2D path object
        return path.contains(p);
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public void setPoint(Point p) {
        Point pOld = this.point;
        Point pNew = p;
        this.point = p;

        // create a transform that helps us move our Path2D
        int tx = pNew.x - pOld.x;
        int ty = pNew.y - pOld.y;       
        AffineTransform at = AffineTransform.getTranslateInstance(tx, ty);
        path.transform(at);  // and then move it
    }    

}