import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Vector2D {

    private DoubleProperty xProperty = new SimpleDoubleProperty(0);
    private DoubleProperty yProperty = new SimpleDoubleProperty(0);

    public Vector2D(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public Vector2D(final Vector2D v) {
        this(v.getX(), v.getY());
    }

    public Vector2D(){this(0,0); }

    public double getX() {
        return xProperty.getValue();
    }

    public void setX(double x) {  this.xProperty.setValue(x);   }

    public double getY() {
        return yProperty.getValue();
    }

    public void setY(double y) {
        this.yProperty.setValue(y);
    }

    public void setVector(Vector2D vector2D) {
        setY(vector2D.getY());
        setX(vector2D.getX());
    }

    public DoubleProperty getXProperty() {
        return xProperty;
    }
    public DoubleProperty getYProperty() {
        return yProperty;
    }
}