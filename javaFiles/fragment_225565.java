public void setDiameter(double diameter) {
    if (diameter <= 0) {
        throw new IllegalArgumentException("diameter must be > 0");
    }
    this.radius = diameter / 2;
}