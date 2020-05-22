import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.security.SecureRandom;

public class MultipleLineChart_Crosshair_Demo extends Application {

    SecureRandom rnd = new SecureRandom();

    @Override
    public void start(Stage stage) {

        Curseur curseur = new Curseur(-1, -1, true);

        CheckBox showCrosshairCB = new CheckBox("Show Crosshair");
        showCrosshairCB.setSelected(curseur.isEstUtilisé());
        showCrosshairCB.selectedProperty().addListener((obs, old, show) -> curseur.setEstUtilisé(show));

        CrossHairLineChart<Number, Number> lineChart1 = buildChart();
        lineChart1.setCursor(curseur);

        CrossHairLineChart<Number, Number> lineChart2 = buildChart();
        lineChart2.setCursor(curseur);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(showCrosshairCB);
        borderPane.setCenter(new VBox(lineChart1, lineChart2));
        borderPane.setPadding(new Insets(5));
        Scene scene = new Scene(borderPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private CrossHairLineChart<Number, Number> buildChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Data");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Super");
        updateSeriesData(series1);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Rate");
        updateSeriesData(series2);

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Stock");
        updateSeriesData(series3);

        final CrossHairLineChart<Number, Number> lineChart = new CrossHairLineChart<>(xAxis, yAxis);
        lineChart.getData().addAll(series1, series2, series3);
        return lineChart;
    }

    private void updateSeriesData(XYChart.Series series) {
        for (int i = 1; i < 13; i = (i + 2)) {
            series.getData().add(new XYChart.Data(i, rnd.nextInt(50)));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class Curseur {
        private DoubleProperty x = new SimpleDoubleProperty();
        private DoubleProperty y = new SimpleDoubleProperty();
        private BooleanProperty estUtilisé = new SimpleBooleanProperty();
        private BooleanProperty showing = new SimpleBooleanProperty();
        private BooleanProperty freeze = new SimpleBooleanProperty();

        public Curseur(double x, double y, boolean estUtilisé) {
            setX(x);
            setY(y);
            this.estUtilisé.set(estUtilisé);
        }

        public double getX() {
            return x.get();
        }

        public DoubleProperty xProperty() {
            return x;
        }

        public void setX(double x) {
            this.x.set(x);
        }

        public double getY() {
            return y.get();
        }

        public DoubleProperty yProperty() {
            return y;
        }

        public void setY(double y) {
            this.y.set(y);
        }

        public boolean isEstUtilisé() {
            return estUtilisé.get();
        }

        public void setEstUtilisé(boolean estUtilisé) {
            this.estUtilisé.set(estUtilisé);
        }

        public BooleanProperty estUtiliséProperty() {
            return estUtilisé;
        }

        public boolean isShowing() {
            return showing.get();
        }

        public BooleanProperty showingProperty() {
            return showing;
        }

        public void setShowing(boolean showing) {
            this.showing.set(showing);
        }

        public boolean isFreeze() {
            return freeze.get();
        }

        public BooleanProperty freezeProperty() {
            return freeze;
        }

        public void setFreeze(boolean freeze) {
            this.freeze.set(freeze);
        }
    }

    /**
     * Custom line chart to include cross hair on plot area.
     *
     * @param <X>
     * @param <Y>
     */
    private class CrossHairLineChart<X, Y> extends LineChart {

        private Line vLine;
        private Line hLine;
        private Group plotArea;
        private BooleanProperty showFlag = new SimpleBooleanProperty();
        private BooleanProperty showCrossHair = new SimpleBooleanProperty();
        private BooleanProperty freeze = new SimpleBooleanProperty();
        private double tickSize = 5;
        private Curseur cursor;

        public CrossHairLineChart(Axis<X> xAxis, Axis<Y> yAxis) {
            super(xAxis, yAxis);
            vLine = new Line();
            hLine = new Line();

            hLine.endYProperty().bind(hLine.startYProperty());
            vLine.endXProperty().bind(vLine.startXProperty());
            vLine.visibleProperty().bind(showFlag.or(freeze));
            hLine.visibleProperty().bind(showFlag.or(freeze));
            setOnMouseExited(e -> {
                if (isShowCrossHair() && !isFreeze()) {
                    showFlag.set(false);
                }
            });
            setOnMouseMoved(e -> {
                if (isShowCrossHair() && plotArea != null && !isFreeze()) {
                    // If the mouse cursor is within the plot area bounds
                    if (isWithinPlotArea(e)) {
                        showFlag.set(true);
                        moveCrossHair(e);
                    } else {
                        showFlag.set(false);
                    }
                }
            });
            setOnMouseClicked(e -> {
                if (isShowCrossHair() && isWithinPlotArea(e)) {
                    freeze.set(!isFreeze());
                    if (!isFreeze()) {
                        moveCrossHair(e);
                    }
                }
            });
        }

        private boolean isWithinPlotArea(MouseEvent e) {
            Bounds b = plotArea.getBoundsInLocal();
            return b.getMinX() < e.getX() && e.getX() < b.getMaxX() && b.getMinY() < e.getY() && e.getY() < b.getMaxY();
        }

        public void setCursor(Curseur cursor) {
            this.cursor = cursor;
            showCrossHair.set(cursor.isEstUtilisé());
            cursor.estUtiliséProperty().addListener((obs, old, show) -> showCrossHair.set(show));
            cursor.xProperty().addListener((obs, old, xVal) -> vLine.setStartX(xVal.doubleValue()));
            cursor.yProperty().addListener((obs, old, yVal) -> hLine.setStartY(yVal.doubleValue()));
            showFlag.bindBidirectional(cursor.showingProperty());
            freeze.bindBidirectional(cursor.freezeProperty());
        }

        private void moveCrossHair(MouseEvent e) {
            Bounds b = plotArea.getBoundsInLocal();
            double x = e.getX() - b.getMinX() - tickSize;
            double y = e.getY() - b.getMinY() - tickSize;

            vLine.setStartX(x);
            hLine.setStartY(y);
            if (cursor != null) {
                cursor.setX(x);
                cursor.setY(y);
            }
        }

        public boolean isShowCrossHair() {
            return showCrossHair.get();
        }

        public BooleanProperty showCrossHairProperty() {
            return showCrossHair;
        }

        public void setShowCrossHair(boolean showCrossHair) {
            this.showCrossHair.set(showCrossHair);
        }

        public boolean isFreeze() {
            return freeze.get();
        }

        @Override
        protected void layoutPlotChildren() {
            super.layoutPlotChildren();
            if (plotArea == null && !getPlotChildren().isEmpty()) {
                Group plotContent = (Group) ((Node) getPlotChildren().get(0)).getParent();
                plotArea = (Group) plotContent.getParent();
            }
            if (!getPlotChildren().contains(vLine)) {
                getPlotChildren().addAll(vLine, hLine);
            }
            hLine.setStartX(0);
            hLine.setEndX(getBoundsInLocal().getWidth());

            vLine.setStartY(0);
            vLine.setEndY(getBoundsInLocal().getHeight());
        }
    }
}