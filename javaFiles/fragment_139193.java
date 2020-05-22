List<Shape> ovals = new ArrayList<Shape>();
List<Shape> arcs = new ArrayList<Shape>();
for (int i = 0; i < pdLen; i++) {
    //g2.fillOval(topLeft[0], topLeft[1] - 10, topRight[0] - topLeft[0], arcHeight);
    ovals.add(new Ellipse2D.Double(topLeft[0], topLeft[1] - 10, topRight[0] - topLeft[0], arcHeight));
    //g2.fillArc(botLeft[0], botLeft[1] - arcHeight / 2, botRight[0] - botLeft[0], arcHeight, 0, -180);
    arcs.add(new Arc2D.Double(botLeft[0], botLeft[1] - arcHeight / 2, botRight[0] - botLeft[0], arcHeight, 0, -180));
}
for (int i=ovals.size()-1; i>=0; i--)
{
    g2.fill(ovals.get(i));
    g2.fill(arcs.get(i));
}