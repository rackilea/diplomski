vertices.add(new Point3D((-size*2/3 + centerX),  t + centerY,  0));
    vertices.add(new Point3D( size*2/3 + centerX,  t + centerY,  0));
    vertices.add(new Point3D(-size*2/3 + centerX, -t + centerY,  0));
    vertices.add(new Point3D( size*2/3 + centerX, -t + centerY,  0));

    vertices.add(new Point3D( centerX, -size*2/3 + centerY,  t));
    vertices.add(new Point3D( centerX,  size*2/3 + centerY,  t));
    vertices.add(new Point3D( centerX, -size*2/3 + centerY, -t));
    vertices.add(new Point3D( centerX,  size*2/3 + centerY, -t));

    vertices.add(new Point3D( t + centerX,  centerY, -size));
    vertices.add(new Point3D( t + centerX,  centerY,  size));
    vertices.add(new Point3D(-t + centerX,  centerY, -size));
    vertices.add(new Point3D(-t + centerX,  centerY,  size));



    // 5 faces around point 0
    faces.add(new Triangle(vertices.get(0),vertices.get(11),vertices.get(5)));
    faces.add(new Triangle(vertices.get(0), vertices.get(5), vertices.get(1)));
    faces.add(new Triangle(vertices.get(0), vertices.get(1), vertices.get(7)));
    faces.add(new Triangle(vertices.get(0), vertices.get(7), vertices.get(10)));
    faces.add(new Triangle(vertices.get(0), vertices.get(10), vertices.get(11)));

    // 5 adjacent faces 
    faces.add(new Triangle(vertices.get(1), vertices.get(5), vertices.get(9)));
    faces.add(new Triangle(vertices.get(5), vertices.get(11), vertices.get(4)));
    faces.add(new Triangle(vertices.get(11), vertices.get(10), vertices.get(2)));
    faces.add(new Triangle(vertices.get(10), vertices.get(7), vertices.get(6)));
    faces.add(new Triangle(vertices.get(7), vertices.get(1), vertices.get(8)));

    // 5 faces around point 3
    faces.add(new Triangle(vertices.get(3), vertices.get(9), vertices.get(4)));
    faces.add(new Triangle(vertices.get(3), vertices.get(4), vertices.get(2)));
    faces.add(new Triangle(vertices.get(3), vertices.get(2), vertices.get(6)));
    faces.add(new Triangle(vertices.get(3), vertices.get(6), vertices.get(8)));
    faces.add(new Triangle(vertices.get(3), vertices.get(8), vertices.get(9)));

    // 5 adjacent faces 
    faces.add(new Triangle(vertices.get(4), vertices.get(9), vertices.get(5)));
    faces.add(new Triangle(vertices.get(2), vertices.get(4), vertices.get(11)));
    faces.add(new Triangle(vertices.get(6), vertices.get(2), vertices.get(10)));
    faces.add(new Triangle(vertices.get(8), vertices.get(6), vertices.get(7)));
    faces.add(new Triangle(vertices.get(9), vertices.get(8), vertices.get(1))); 

    Point3D a;
    Point3D b;
    Point3D c;
    for (int i = 0; i < recursionLevel; i++) {
        ArrayList<Face2D> faces2 = new ArrayList<Face2D>();
        while(faces.size() != 0){
            a = createMiddlePoint(faces.get(0).vertices[0], faces.get(0).vertices[1]);
            b = createMiddlePoint(faces.get(0).vertices[1], faces.get(0).vertices[2]);
            c = createMiddlePoint(faces.get(0).vertices[2], faces.get(0).vertices[0]);

            faces2.add(new Triangle(faces.get(0).vertices[0], a, c));
            faces2.add(new Triangle(faces.get(0).vertices[1], b, a));
            faces2.add(new Triangle(faces.get(0).vertices[2], c, b));
            faces2.add(new Triangle(a, b, c));
            faces.remove(0);
        }
      System.out.println("Recursion Level: " + i + ", Faces:" + faces2.size());
      //System.out.println("" + (System.currentTimeMillis() - startTime));
      faces = faces2;
    }
}

private Point3D createMiddlePoint(Point3D p1, Point3D p2){
    Point3D middle = new Point3D(
        (int)((p1.x + p2.x) / 2.0 - centerX), 
        (int)((p1.y + p2.y) / 2.0 - centerY), 
        (int)((p1.z + p2.z) / 2.0));
    if(radius == -1){
        radius = (size*(1.0 + Math.sqrt(5.0)))/2;
    }
    // add vertex makes sure point is on unit sphere (Problem lies in these two statements)
    double magnitude = Math.sqrt(Math.pow(middle.x,2)+Math.pow(middle.y,2)+Math.pow(middle.z,2));

    return new Point3D((int)((middle.x)*radius/magnitude) + centerX, (int)((middle.y)*radius/magnitude) + centerY, (int)(middle.z*radius/magnitude));
}