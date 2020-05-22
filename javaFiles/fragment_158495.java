import java.util.List;

import javafx.beans.NamedArg;
import javafx.scene.shape.Polygon;

public class DPolygon extends Polygon {

    public DPolygon(@NamedArg("points") List<Double> points) {
        super(points.stream().mapToDouble(Double::doubleValue).toArray());
    }
}