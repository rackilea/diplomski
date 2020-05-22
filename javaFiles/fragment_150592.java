private double getCircleArea() {
        return Math.PI*radius*radius;
}

public double getArea() {
        return getCircleArea();
}

public String toString() {
        return "Circle Area: " + this.getCircleArea();
}