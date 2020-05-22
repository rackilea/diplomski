public void mouseClicked(MouseEvent e) {
...
   Polygon[] triArray = triangles.toArray(new Polygon[triangles.size()]);
   startDrag = new Point(e.getX(), e.getY());
   for (Polygon p:triArray){
    if (p.contains(startDrag)) //Polygon has a 'contains(Point)' method
           triangles.remove (p);
   }
....