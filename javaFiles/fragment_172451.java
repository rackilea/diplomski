interface Shape {
   void printArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    public void printArea() {
        System.out.println(this.getArea());
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getArea() {
        return radius * radius * 3;
    }

    public void printArea() {
        System.out.println(this.getArea());
    }
}