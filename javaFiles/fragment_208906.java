private ArrayList<Point> oldpoints = new ArrayList<Point>();  

private void setPointColor(GC g, Point cpoint) {
    if (oldpoints.contains(cpoint)) {
        g.setForeground(cGreen);
    } else if (!oldpoints.contains(cpoint)) {
        g.setForeground(cRed);
    }

    if (cpoint.equals(currentPoint)) {
         g.setForeground(cBlue);
         oldpoints.add(cpoint);
    } 
}