pointList = new Point3d[8];

    pointList[WEST|SOUTH|BOTTOM] = new Point3d(x0,y0,z0);
    pointList[WEST|SOUTH|TOP]    = new Point3d(x0,y0,z1);
    pointList[WEST|NORTH|BOTTOM] = new Point3d(x0,y1,z0);
    pointList[WEST|NORTH|TOP]    = new Point3d(x0,y1,z1);
    pointList[EAST|SOUTH|BOTTOM] = new Point3d(x1,y0,z0);
    pointList[EAST|SOUTH|TOP]    = new Point3d(x1,y0,z1);
    pointList[EAST|NORTH|BOTTOM] = new Point3d(x1,y1,z0);
    pointList[EAST|NORTH|TOP]    = new Point3d(x1,y1,z1);