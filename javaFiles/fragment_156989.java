Arrays.fill(Fx, 0.0);
Arrays.fill(Fy, 0.0);
for (int body = 0; body < bodyNum - 1; body++) {
    for (int body2 = body + 1; body2 < bodyNum; body2++) {
        double dx = x[body2] - x[body];
        double dy = y[body2] - y[body];
        double d2 = dx * dx + dy * dy;
        double d = Math.sqrt(d2);
        double f = G * m[body] * m[body2] / d2;
        double fx = f * dx / d;
        double fy = f * dy / d;
        Fx[body] += fx;
        Fy[body] += fy;
        Fx[body2] -= fx;
        Fy[body2] -= fy;
    }
}
// then update positions and velocities based on Fx and Fy arrays