class Point {
    public int x = 0;
    public int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
       return x + "," + y;
    }
}


class Point3D extends Point {
    public int z = 0;

    public Point(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }

    public String toString() {
       return super.toString() + "," + z;
    }
}