// constant for Earth's gravity acceleration in meters/second^2
public static final double ACCELERATION = -9.81;

// returns the displacement for a body under acceleration
public static double displacement(double v0, double t, double a) {
    return v0 * t + 0.5 * a * t * t;
}

// prints a table showing the trajectory of an object given
// its initial velocity v and angle and number of steps
public static void table(double v0, double angle, int steps) {
    double v0x = v0 * Math.cos(Math.toRadians(angle));
    double v0y = v0 * Math.sin(Math.toRadians(angle));
    double totalTime = -2.0 * v0y / ACCELERATION;
    double dt = totalTime / steps;

    System.out.println("    step       x       y    time");
    for (int i = 0; i <= steps; i++) {
        double time = i * dt;
        double x = i * v0x * dt;
        double y = displacement(v0y, time, ACCELERATION);
        System.out.printf("%8d%8.2f%8.2f%8.2f\n", i, x, y, time);
    }
}