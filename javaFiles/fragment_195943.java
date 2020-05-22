int i,j,N=?;       // N is number of input points in pnt[]
    double x,y,d=?,dd=d*d,de=0.1*d; // d is the avg grid size
    double pnt[N][2]=?;    // your 2D points
    for (i=0;i<N;i++)      // i - all points
     for (j=i+1;j<N;j++)   // j - just the rest no need to test already tested combinations
       {
       x=pnt[i][0]-pnt[j][0];
       y=pnt[i][1]-pnt[j][1];
       if (fabs((x*x)+(y*y)-dd)<=de) ... // add line pnt[i],pnt[j] to the list...
       }