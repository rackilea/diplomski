private final DoubleProperty radius = new SimpleDoubleProperty();

public DoubleProperty radiusProperty() {
    return radius;
}

public double getRadius() {
    return radius.get();
}

public void setRadius(double value) {
    radius.set(value);
}