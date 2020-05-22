double radius = 3;
for (double x = -radius; x <= radius; x += 0.01) {
    double y = Math.sqrt(radius * radius - x * x);
    plot(x, y);//top half of the circle
    plot(x, -y);//bottom half of the circle
}