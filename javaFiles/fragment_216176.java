Point[] points = new Point[5];
    points[0] = new Point(30,20);
    points[1] = new Point(80,10);
    points[2] = new Point(75,100);
    points[3] = new Point(40,100);
    points[4] = new Point(55,65);

    System.out.println(isPointInPolygon(new Point(76,82), points) );