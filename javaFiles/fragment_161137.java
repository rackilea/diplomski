// number of corners of pentagon
    double numVertex = 5;
    // how much to change the angle for the next corner( of the turtle )
    double angleStep = 360.0 / numVertex;
    gc.moveTo(cx, cy - rad);
    for (int i= 1; i < numVertex; i++) {
         // total angle from 0 degrees
         double angle = i* angleStep;
         // px point of turtle is corner of pentagon
         double px = cx + rad * sin(angle * DEG_TO_RADIANS);
         // move turtle to
         gc.lineto((int)Math.round(px),
         (int)Math.round(py));
    }
     gc.lineTo(cx, cy - rad);