// Start point
private double x;
private double y;
private double z;

private double degree;
private double rY;
@Override
public void run() {
    // We use the same formula that is used to find a point of a circumference
    double rX = Math.cos(degree);
    double rZ = Math.sin(degree);
    // New point
    double pX = x + rX;
    double pY = y + rY;
    double pZ = z + rZ;

    if (degree > 2D * Math.PI) {
        degree = 0D;
    } else {
        degree = degree + 0.2D;
    }
    if (pY > 2D) {
        pY = 0D;
    } else {
        pY = pY + 0.02D;
    }
}