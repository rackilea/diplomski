public class Circle implements Shape {
    Circle getType() { }
    void setType(Circle circle) {  }

    // Bridge method added by compiler.
    Shape getType() { return getType(); }  // delegate to actual method
    void setType(Shape shape) { setType((Circle)shape); }  // delegate to actual method
}