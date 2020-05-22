List<ShapeProcessor<Circle>> circleProcessors = new ArrayList<ShapeProcessor<Circle>>(
 Arrays.asList(new CircleDrawer(), new ShapeSaver<Circle>()));

public interface ShapeProcessor<T extends Shape> {
    void execute(T t);
}

public class CircleDrawer implements ShapeProcessor<Circle> {
    @Override
    public void execute(Circle circle) {
        // Draw circle
    }
}

public class ShapeSaver<T extends Shape> implements ShapeProcessor<T> {
    @Override
    public void execute(T t) {
        t.save();
    }
}