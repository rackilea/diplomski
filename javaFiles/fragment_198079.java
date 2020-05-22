import javafx.beans.NamedArg;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.chart.Axis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.layout.Region;

public class ScatterQuadrantChart<X,Y> extends ScatterChart<X,Y> {

    private final Property<X> xQuadrantDivider = new SimpleObjectProperty<>();
    private final Property<Y> yQuadrantDivider = new SimpleObjectProperty<>();

    private final Region nwQuad ;
    private final Region neQuad ;
    private final Region swQuad ;
    private final Region seQuad ;

    public ScatterQuadrantChart(@NamedArg("xAxis") Axis<X> xAxis, 
            @NamedArg("yAxis") Axis<Y> yAxis) {
        super(xAxis, yAxis);
        nwQuad = new Region();
        neQuad = new Region();
        swQuad = new Region();
        seQuad = new Region();
        nwQuad.setStyle("-fx-background-color: lightsalmon ;");
        neQuad.setStyle("-fx-background-color: antiquewhite ;");
        swQuad.setStyle("-fx-background-color: aqua ;");
        seQuad.setStyle("-fx-background-color: lightskyblue ;");
        getPlotChildren().addAll(nwQuad, neQuad, swQuad, seQuad);

        ChangeListener<Object> quadListener = (obs, oldValue, newValue) -> layoutPlotChildren();
        xQuadrantDivider.addListener(quadListener);
        yQuadrantDivider.addListener(quadListener);
    }

    @Override
    public void layoutPlotChildren() {
        super.layoutPlotChildren();
        X x = xQuadrantDivider.getValue();
        Y y = yQuadrantDivider.getValue();
        if (x != null && y != null) {
            Axis<X> xAxis = getXAxis();
            Axis<Y> yAxis = getYAxis();
            double xPixels = xAxis.getDisplayPosition(x);
            double yPixels = yAxis.getDisplayPosition(y);
            double totalWidth = xAxis.getWidth();
            double totalHeight = yAxis.getHeight();
            nwQuad.resizeRelocate(0, 0, xPixels, yPixels);
            swQuad.resizeRelocate(0, yPixels, xPixels, totalHeight - yPixels);
            neQuad.resizeRelocate(xPixels, 0, totalWidth - xPixels, yPixels);
            seQuad.resizeRelocate(xPixels, yPixels, totalWidth - xPixels, totalHeight - yPixels);
        }
    }

    public final Property<X> xQuadrantDividerProperty() {
        return this.xQuadrantDivider;
    }

    public final X getXQuadrantDivider() {
        return this.xQuadrantDividerProperty().getValue();
    }

    public final void setXQuadrantDivider(final X xQuadrantDivider) {
        this.xQuadrantDividerProperty().setValue(xQuadrantDivider);
    }

    public final Property<Y> yQuadrantDividerProperty() {
        return this.yQuadrantDivider;
    }

    public final Y getYQuadrantDivider() {
        return this.yQuadrantDividerProperty().getValue();
    }

    public final void setYQuadrantDivider(final Y yQuadrantDivider) {
        this.yQuadrantDividerProperty().setValue(yQuadrantDivider);
    }


}