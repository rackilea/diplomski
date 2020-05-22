public void customize(JFreeChart chart, ChartComponent chartComponent)
{
  //get the ploy
  CategoryPlot plot = (CategoryPlot) chart.getPlot();

  //Now add your markers
  ValueMarker vm = new ValueMarker(200); //200 is the position you like it to be
  vm.setPaint(Color.RED);
  vm.setStroke(new BasicStroke(1));
  vm.setLabel("BeanchMark value"); //The label
  vm.setLabelAnchor(RectangleAnchor.TOP);
  vm.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
  plot.addRangeMarker(vm);
}