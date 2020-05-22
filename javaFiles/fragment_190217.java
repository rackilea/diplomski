double a,da,x,y,x0=0,y0=0,rx=50,ry=20;  // ellipse x0,y0,rx,ry
int i,N=32;                                // divided to N = segments
da=2.0*M_PI/double(N);

for (a=0.0,i=0;i<N;i++,a+=da)
    {
    x=x0+(rx*cos(a));
    y=y0+(ry*sin(a));
    // draw_line(x0,y0,x,y);
    }