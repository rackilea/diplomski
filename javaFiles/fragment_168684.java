boolean b = true;
  while (pointIterator.hasNext())
  {
     page.setColor( b ? Color.green : Color.red);
     b = !b;
     Point drawPoint = (Point) pointIterator.next();
     page.fillOval (drawPoint.x - RADIUS, drawPoint.y - RADIUS,
                    RADIUS * 2, RADIUS * 2);
  }