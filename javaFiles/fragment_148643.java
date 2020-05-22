public double perceOf2Rect(Rectangle2D r1, Rectangle2D r2){
    Rectangle2D r = new Rectangle2D.Double();
    Rectangle2D.intersect(r1, r2, r);

    double fr1 = r1.getWidth() * r1.getHeight();                // area of "r1"
    double f   = r.getWidth() * r.getHeight();                  // area of "r" - overlap
    return (fr1 == 0 || f <= 0) ? 0 : (f / fr1) * 100;          // overlap percentage
}