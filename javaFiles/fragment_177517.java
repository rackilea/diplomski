double x = dataset.getXValue(0, COUNT - 1);
double y = dataset.getYValue(0, COUNT - 1);
String s = dataset.getY(0, COUNT - 1).toString();
XYTextAnnotation a = new XYTextAnnotation(s, x, y);
a.setFont(a.getFont().deriveFont(24f));
plot.addAnnotation(a);