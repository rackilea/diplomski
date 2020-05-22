import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.shape.Line;

public class ScatterPlotWithBestFitLine extends ScatterChart<Number, Number> {

    private final NumberAxis xAxis ;
    private final NumberAxis yAxis ;

    private final List<Line> lines = new ArrayList<>();


    public ScatterPlotWithBestFitLine(NumberAxis xAxis, NumberAxis yAxis) {
        super(xAxis, yAxis);
        this.xAxis = xAxis ;
        this.yAxis = yAxis ;

        getStylesheets().add("best-fit-line.css");
    }

    @Override
    protected void layoutPlotChildren() {

        getPlotChildren().removeAll(lines);
        lines.clear();

        super.layoutPlotChildren();

        int index = 0 ;
        for (Series<Number, Number> series : getData()) {

            Line line = new Line();
            line.setStartX(xAxis.getDisplayPosition(xAxis.getLowerBound()));
            line.setEndX(xAxis.getDisplayPosition(xAxis.getUpperBound()));

            int count = (index % 8) + 1 ;
            line.getStyleClass().add("best-fit-line");
            line.getStyleClass().add("best-fit-line-"+count);

            // TODO compute actual line of best fit...
            // can iterate through values with:

            // for (Data<Number, Number> d : series.getData()) {
            //     double x = d.getXValue().doubleValue();
            //     double y = d.getYValue().doubleValue();
            // }

            // just dummy values:
            double m = 0 ;
            double b = (getData().size() - index) * yAxis.getLowerBound() + (index + 1) * yAxis.getUpperBound() / 2 ;

            line.setStartY(yAxis.getDisplayPosition(m * xAxis.getLowerBound() + b));
            line.setEndY(yAxis.getDisplayPosition(m * xAxis.getUpperBound() + b));

            getPlotChildren().add(line);
            lines.add(line);

            index++ ;
        }
    }


}