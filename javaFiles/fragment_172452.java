public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        rectangle.printArea();
        Shape circle = new Circle(20);
        circle.printArea();
        Printer printer = new Printer();
        printer.printArea(circle);
        printer.printArea(rectangle);
}