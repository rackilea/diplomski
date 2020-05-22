import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Grid {
    private final Pane view = new Pane();

    private final int numColumns ;
    private final int numRows ;

    // arbitrary defaults of 20:
    private final DoubleProperty prefColumnWidth = new SimpleDoubleProperty(20);
    private final DoubleProperty prefRowHeight = new SimpleDoubleProperty(20);

    public Grid(int numColumns, int numRows) {
        this.numColumns = numColumns ;
        this.numRows = numRows ;

        for (int x = 0 ; x <= numColumns ; x++) {
            Line line = new Line();
            line.startXProperty().bind(view.widthProperty().multiply(x).divide(numColumns));
            line.endXProperty().bind(line.startXProperty());
            line.setStartY(0);
            line.endYProperty().bind(view.heightProperty());
            view.getChildren().add(line);
        }

        for (int y = 0 ; y <= numRows ; y++) {
            Line line = new Line();
            line.startYProperty().bind(view.heightProperty().multiply(y).divide(numRows));
            line.endYProperty().bind(line.startYProperty());
            line.setStartX(0);
            line.endXProperty().bind(view.widthProperty());
            view.getChildren().add(line);
        }

        view.prefWidthProperty().bind(prefColumnWidth.multiply(numColumns));
        view.prefHeightProperty().bind(prefRowHeight.multiply(numRows));
    }

    public final DoubleProperty prefColumnWidthProperty() {
        return this.prefColumnWidth;
    }


    public final double getPrefColumnWidth() {
        return this.prefColumnWidthProperty().get();
    }


    public final void setPrefColumnWidth(final double prefColumnWidth) {
        this.prefColumnWidthProperty().set(prefColumnWidth);
    }


    public final DoubleProperty prefRowHeightProperty() {
        return this.prefRowHeight;
    }


    public final double getPrefRowHeight() {
        return this.prefRowHeightProperty().get();
    }


    public final void setPrefRowHeight(final double prefRowHeight) {
        this.prefRowHeightProperty().set(prefRowHeight);
    }

    public Pane getView() {
        return view;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumRows() {
        return numRows;
    }

}