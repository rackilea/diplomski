import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class Cell {

    private final ObjectProperty<Shape> shape = new SimpleObjectProperty<>(new Shape());


    public final ObjectProperty<Shape> shapeProperty() {
        return this.shape;
    }




    public final Cell.Shape getShape() {
        return this.shapeProperty().get();
    }




    public final void setShape(final Cell.Shape shape) {
        this.shapeProperty().set(shape);
    }


    public static class Shape {

        private final IntegerProperty size = new SimpleIntegerProperty(0);
        private final ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);
        public final IntegerProperty sizeProperty() {
            return this.size;
        }

        public final int getSize() {
            return this.sizeProperty().get();
        }

        public final void setSize(final int size) {
            this.sizeProperty().set(size);
        }

        public final ObjectProperty<Color> colorProperty() {
            return this.color;
        }

        public final javafx.scene.paint.Color getColor() {
            return this.colorProperty().get();
        }

        public final void setColor(final javafx.scene.paint.Color color) {
            this.colorProperty().set(color);
        }

    }


    public static void main(String[] args) {
        Cell cell = new Cell();
        Bindings.selectInteger(cell.shapeProperty(), "size").addListener(
                (obs, oldSize, newSize) -> System.out.println("Size changed from "+oldSize+" to "+newSize));
        cell.getShape().setSize(10);
        cell.setShape(new Shape());
        Shape s = new Shape();
        s.setSize(20);
        cell.setShape(s);
    }

}