import java.awt.Color;
import java.awt.Rectangle;

public class Shape extends Rectangle {

    Color colour;

    public Shape(int x, int y, int width, int height) {
        // provided by the Rectangle class. Needed for proper collision detection
        super(x, y, width, height);
    }
}