class Shape {
    double bLength;
    double area;

    Shape(double bLength, double area) {
        this.bLength = bLength;
        this.area = area;
    }
}

class Square extends Shape {
    Square(double bLength, double area) {
        super(bLength, area);
    }
    // additional field, methods...
}

// same for the other shapes