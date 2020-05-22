Shape.java

public class Shape {
    public void draw() {
        System.out.println("Shape#draw");
    }
}

Painter.java

public class Painter {
    public static void main(String[] args) {
         Shape shape = new Shape();
         shape.draw();
    }
}