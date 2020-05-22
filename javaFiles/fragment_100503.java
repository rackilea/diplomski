float dx = dist * Math.cos(angle);
float dy = dist * Math.sin(angle);
for (float p = 0.0; p <= 1.0; p = Math.min(1.0, p + dist / v) {
    x = sx + p * (dx - sx);
    y = sy + p * (dy - sy);
}