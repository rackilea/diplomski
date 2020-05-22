public static void main(String[] args) {
    One orig = new One(1, "hi", 3);
    One to = new One();
    One copy = copyTo(orig, to);
    System.out.println(to);
}

static class One {
    int x;
    String y;
    double z;

    public One() {
    }

    public One(int x, String y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "One{" +
                "x=" + x +
                ", y='" + y + '\'' +
                ", z=" + z +
                '}';
    }
}