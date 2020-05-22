public void handle(MouseEvent event) {
    Point2D pointInScene = new Point2D(event.getSceneX(), event.getSceneY());
    Axis<Number> xAxis = lineChart.getXAxis();
    Axis<Number> yAxis = lineChart.getYAxis();
    double xPosInAxis = xAxis.sceneToLocal(new Point2D(pointInScene.getX(), 0)).getX();
    double yPosInAxis = yAxis.sceneToLocal(new Point2D(0, pointInScene.getY())).getY();
    double x = xAxis.getValueForDisplay(xPosInAxis).doubleValue();
    double y = yAxis.getValueForDisplay(yPosInAxis).doubleValue();

    Tooltip t = new Tooltip("X: "+x+", Y:"+y);
    t.show(stage);
}