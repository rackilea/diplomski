Line2D.Double line2d = new Line2D.Double(10, 10, 10, 30);
Rectangle2D.Double rect2d = new Rectangle2D.Double(0, 0, 100, 100);

boolean intersect = line2d.getBounds2D().intersects(rect2d);
System.out.println(intersect);
System.out.println(line2d.getBounds2D());