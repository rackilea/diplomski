import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        ShapeArray shapeArray = new ShapeArray();
        shapeArray.addShapeToArray(new Shape());
        shapeArray.addShapeToArray(new Circle(2));
        System.out.println(shapeArray.getShape(0).getRadius());
    }
}