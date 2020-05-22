package rotation;

import static org.junit.Assert.*;
import org.junit.Test;

public class RotationTest {
    public enum Direction { RIGHT, LEFT, EITHER }

    public Direction getDirection(double current, double target) {
        validate(current);
        validate(target);
        double alwaysLarger = current < target ? (current + 360) : current;
        double gap = alwaysLarger - target;
        return gap > 180
            ? Direction.RIGHT
            : (gap == 180 ? Direction.EITHER : Direction.LEFT);
    }

    private void validate(double degrees) {
        if (degrees < 0 || degrees > 360) {
            throw new IllegalStateException();
        }
    }

    @Test
    public void test() {
        assertEquals(Direction.LEFT, getDirection(90, 1));
        assertEquals(Direction.LEFT, getDirection(90, 359));
        assertEquals(Direction.LEFT, getDirection(90, 271));
        assertEquals(Direction.EITHER, getDirection(90, 270));
        assertEquals(Direction.RIGHT, getDirection(90, 269));
        assertEquals(Direction.RIGHT, getDirection(90, 180));
    }
}