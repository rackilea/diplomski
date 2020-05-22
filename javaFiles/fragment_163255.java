Point p = chart.getLocation();     
int px = p.getX();
int py = p.getY();

x = x-px; // x from event
y = y-py; // y from event
// x and y are now coordinates in respect to the chart

if(x<0 || y<0 || x>chart.getWidth() || y>chart.getHeight()) // the click was outside of the chart
else // the click happened within boundaries of the chart and