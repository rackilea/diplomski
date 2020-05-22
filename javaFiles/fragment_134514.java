void perspective(double *P) // apply perspective transform on P
    {
    // perspectve division
    P[0]*=znear/P[2];
    P[1]*=znear/P[2];
    // screen coordinate system
    P[0]=xs2+P[0];          // move (0,0) to screen center
    P[1]=ys2-P[1];          // axises: x=right, y=up
    }