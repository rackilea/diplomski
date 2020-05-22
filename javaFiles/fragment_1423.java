public List<RPoint> TDNeighborsOnALine(RPoint endPoint){        
    List<RPoint> points = new ArrayList<>();
    if (Geometry.distanceTwoPoints(this, endPoint) > 1){
        int vx = Math.max(-1, Math.min(1, (endPoint.getX()-x)));
        int vy = Math.max(-1, Math.min(1, (endPoint.getY()-y)));
        int vz = Math.max(-1, Math.min(1, (endPoint.getZ()-z)));
        RPoint b = new RPoint (x + vx, y + vy, z + vz);
        RPoint c = new RPoint (x + (vx*2), y + (vy*2), z + (vz*2));
        for (int ox = -1; ox < 2; ox++){
            for (int oy = -1; oy < 2; oy ++){
                for (int oz = -1; oz < 2; oz++){
                    RPoint p = new RPoint(ox + x, oy + y, oz + z);
                    double d = Geometry.distanceTwoPoints(c, p);
                    if (d < Geometry.distanceTwoPoints(c, this) && d <= 3){
                        points.add(p);
                    }
                }
            }
        }
    } else {
        points.add(endPoint);
    }
    return points;
}

public static double distanceTwoPoints(RPoint a, RPoint b){
    return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2) + Math.pow((a.getZ() - b.getZ()), 2));
}