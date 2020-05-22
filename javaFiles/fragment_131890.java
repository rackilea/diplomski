double x = 150;
double y = 300;
XYPlot plot = chart.getXYPlot();
ImageIcon imageIcon = new ImageIcon("/path/to/your/icon.png");
XYAnnotation xyannotation = new XYImageAnnotation(x, y, imageIcon.getImage());
plot.addAnnotation(xyannotation);