➜  /tmp cat thing/Shape.java actor/Painter.java 
package thing;
class Shape {
    public void draw() {
        System.out.println("Shape#draw");
    }
}
package actor;
import thing.Shape; // need to import Shape from thing package now
class Painter {
    public static void main(String[] args) {
         Shape shape = new Shape();
         shape.draw();
    }
}