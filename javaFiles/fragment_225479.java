public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException {
    try {
        setSides(side1, side2, side3);(IllegalTriangleException ex) {
        System.out.println("Illegal Triangle: The summ of any two sides must be greater than the other side" + side1 + "," + side2 + "," + side3);
    }
}