Point p = new Point(1, 2);
 // ColoredPoint extends Point
 ColoredPoint c = new ColoredPoint(1, 2, Color.RED);
 // this is true because both points are at the location 1, 2
 assertTrue(p.equals(c));
 // however, this would return false because the Point p does not have a color
 assertFalse(c.equals(p));