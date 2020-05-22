public class GraphHelper {

public GraphHelper() { }

public static void initializeGraph(GraphView graph, LineGraphSeries<DataPoint> xSeries,
                                   LineGraphSeries<DataPoint> ySeries, LineGraphSeries<DataPoint> zSeries, short maxDisplayed){
    graph.getLegendRenderer().setVisible(true);
    graph.getLegendRenderer().setFixedPosition(0, 0);

    graph.getGridLabelRenderer().setHighlightZeroLines(false);

    xSeries.setTitle("X");
    ySeries.setTitle("Y");
    zSeries.setTitle("Z");

    xSeries.setColor(Color.RED);
    ySeries.setColor(Color.GREEN);
    zSeries.setColor(Color.BLUE);

    graph.addSeries(xSeries);
    graph.addSeries(ySeries);
    graph.addSeries(zSeries);

    graph.getViewport().setYAxisBoundsManual(true);
    graph.getViewport().setMinY(-10);
    graph.getViewport().setMaxY(10);

    graph.getViewport().setXAxisBoundsManual(true);
    graph.getViewport().setMinX(0);
    graph.getViewport().setMaxX(maxDisplayed);
}
}