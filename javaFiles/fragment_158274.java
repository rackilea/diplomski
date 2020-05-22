import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Region;

public class Grid extends Region {

    private Canvas canvas ;
    private final int numColumns ;
    private final int numRows ;

    public Grid(int numColumns, int numRows) {
        this.numColumns = numColumns ;
        this.numRows = numRows ;
        canvas = new Canvas();
        getChildren().add(canvas);
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth() - getPadding().getLeft() - getPadding().getRight() ;
        double h = getHeight() - getPadding().getTop() - getPadding().getBottom() ;

        canvas.setWidth(w+1);
        canvas.setHeight(h+1);

        canvas.setLayoutX(getPadding().getLeft());
        canvas.setLayoutY(getPadding().getRight());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, w, h);

        for (int i = 0 ; i <= numColumns ; i++) {

            // adding 0.5 here centers the line in the physical pixel,
            // making it appear crisper:
            double x = w*i/numColumns + 0.5;

            gc.strokeLine(x, 0, x, h);
        }

        for (int j = 0 ; j <= numRows ; j++) {
            double y = h*j/numRows + 0.5 ;
            gc.strokeLine(0, y, w, y);
        }
    }

    @Override
    protected double computePrefWidth(double height) {
        return 20 * numColumns;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 20 * numRows ;
    }

}