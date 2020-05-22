public interface Shape {
    void draw();
    void myJob();
}

public class MyClass {
    public void myJob(Shape shape) {
        shape.myJob();
    }
}