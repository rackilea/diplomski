int ax = oldPoint.getLatitude();
int ay = oldPoint.getLongitude();

int bx = currentPoint.getLatitude();
int by = currentPoint.getLongitude();

long at = oldPoint.getDataRilevamento(); //get time first point
long bt = currentPoint.getDataRilevamento(); // get time second point
long xt = x.getDate(); // time of point to find

// Find relative time from point A to point B
double t=(bt==at) ? 0 : ((double)(xt-at))/((double)(bt-at));
// Find new point given the start and end points and the relative time
int[] xpos=getIntermediatePoint(ax,ay,bx,by,t);
x.setLatitude(xpos[0]); //set the latitude of X
x.setLongitude(xpos[1]); // set the longitude of X