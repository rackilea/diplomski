private final Group plotArea = new Group(){
  @Override public void requestLayout() {} // suppress layout requests
};
private final Group plotContent = new Group();
private final Rectangle plotAreaClip = new Rectangle();

public XYChart(Axis<X> xAxis, Axis<Y> yAxis) {
...
getChartChildren().addAll(plotBackground,plotArea,xAxis,yAxis);
...
plotArea.setClip(plotAreaClip);
...
}