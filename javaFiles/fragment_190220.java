void get_edge_pnt(double &x,double &y,int segment,int segments)
 {
 double a;
 a=2.0*M_PI/double(segments);
 a*=double(segment);       // this is segments start edge point
 //a*=double(segment+1);  // this is segments end edge point
 x=x0+(rx*cos(a));
 y=y0+(ry*sin(a));
 }