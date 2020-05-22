import java.awt.*;

public class Box<T extends Comparable<T>> {

    public static void main(String[] args) {
        Box a = new Box();
        Box b = new Box<>();
        Box c = new Box<Integer>();
        Box d = new Box<String>();

        // This one will not work as Rectangle does not implement Comparable!
        Box e = new Box<Rectangle>(); 
    }
}