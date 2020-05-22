import java.util.ArrayList;
import java.util.List;

interface DrawableSegment {}

class LineSegment implements  DrawableSegment {}

class PercentageSegment implements  DrawableSegment {}

class BarChart<T extends DrawableSegment> {
    private List<T> drawableSegments = new ArrayList<>();

    public void add(T drawableSegment) {
        this.drawableSegments.add(drawableSegment);
    }

    public List<T> getDrawableSegments() {
        return this.drawableSegments;
    }
}

public static void main(String[] args) {
    BarChart<LineSegment> barCharLineSegment = new BarChart<LineSegment>();
    barCharLineSegment.add(new LineSegment());
    barCharLineSegment.add(new PercentageSegment()); // Compiler Error: cannot be applied
}