public Shape getShape() {
    if(circle){
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }else{
        return new Rectangle((int)x,(int)y,XSIZE,YSIZE);
    }
}

private static boolean circle=true;
private static int XSIZE = 15;
private static int YSIZE = 15;

public static int getXsize() {
    return XSIZE;
}

public static int getYsize() {
    return YSIZE;
}

public static int getXSIZE() {
    return XSIZE;
}

public static void setXSIZE(int xSIZE) {
    XSIZE = xSIZE;
}

public static int getYSIZE() {
    return YSIZE;
}

public static void setYSIZE(int ySIZE) {
    YSIZE = ySIZE;
}

public static boolean isCircle() {
    return circle;
}

public static void setCircle(boolean circle) {
    Ball.circle = circle;
}