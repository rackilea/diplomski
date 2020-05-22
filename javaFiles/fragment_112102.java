import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.security.SecureRandom;

public class LineChart_Crosshair_Demo extends Application {

    SecureRandom rnd = new SecureRandom();

    @Override
    public void start(Stage stage) {
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

        Line vLine = new Line();
        Line hLine = new Line();
        Curseur curseur = new Curseur(vLine, hLine, true);

        final CrossHairLineChart<Number, Number> lineChart = new CrossHairLineChart<>(xAxis, yAxis, curseur);
        lineChart.getData().addAll(series1, series2, series3);

        CheckBox showCrosshairCB = new CheckBox("Show Crosshair");
        showCrosshairCB.setSelected(curseur.isEstUtilisé());
        showCrosshairCB.selectedProperty().addListener((obs, old, show) -> curseur.setEstUtilisé(show));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(showCrosshairCB);
        borderPane.setCenter(lineChart);
        borderPane.setPadding(new Insets(5));
        Scene scene = new Scene(borderPane, 800, 600);
        stage.setScene(scene);
        stage.show();
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
        private Line vLine;
        private Line hLine;
        private BooleanProperty estUtilisé = new SimpleBooleanProperty();

        public Curseur(Line vLine, Line hLine, boolean estUtilisé) {
            this.vLine = vLine;
            this.hLine = hLine;
            this.estUtilisé.set(estUtilisé);
        }

        public Line getvLine() {
            return vLine;
        }

        public Line gethLine() {
            return hLine;
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
        private double tickSize = 5;

        public CrossHairLineChart(Axis<X> xAxis, Axis<Y> yAxis, Curseur curseur) {
            super(xAxis, yAxis);
            vLine = curseur.getvLine();
            hLine = curseur.gethLine();
            showCrossHair.set(curseur.isEstUtilisé());
            curseur.estUtiliséProperty().addListener((obs, old, show) -> showCrossHair.set(show));

            hLine.endYProperty().bind(hLine.startYProperty());
            vLine.endXProperty().bind(vLine.startXProperty());
            vLine.visibleProperty().bind(showFlag);
            hLine.visibleProperty().bind(showFlag);
            setOnMouseExited(e -> showFlag.set(false));
            setOnMouseMoved(e -> {
                if (isShowCrossHair() && plotArea != null) {
                    Bounds b = plotArea.getBoundsInLocal();
                    // If the mouse cursor is within the plot area bounds
                    if (b.getMinX() < e.getX() && e.getX() < b.getMaxX() && b.getMinY() < e.getY() && e.getY() < b.getMaxY()) {
                        showFlag.set(true);
                        moveCrossHair(e.getX() - b.getMinX() - tickSize, e.getY() - b.getMinY() - tickSize);
                    } else {
                        showFlag.set(false);
                    }
                }
            });
        }

        private void moveCrossHair(double x, double y) {
            vLine.setStartX(x);
            hLine.setStartY(y);
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