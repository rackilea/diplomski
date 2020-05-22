void draw_line(TCanvas *can,double *pA,double *pB)  // draw 3D line
    {
    int i;
    double D[3],A[3],B[3],t;
    // transform to camera coordinate system
    matrix_mul_vector(A,icamera,pA);
    matrix_mul_vector(B,icamera,pB);
    // sort points so A.z<B.z
    if (A[2]>B[2]) for (i=0;i<3;i++) { D[i]=A[i]; A[i]=B[i]; B[i]=D[i]; }
    // D = B-A
    for (i=0;i<3;i++) D[i]=B[i]-A[i];
    // ignore out of Z view lines
    if (A[2]>zfar) return;
    if (B[2]<znear) return;
    // cut line to view if needed
    if (A[2]<znear)
        {
        t=(znear-A[2])/D[2];
        A[0]+=D[0]*t;
        A[1]+=D[1]*t;
        A[2]=znear;
        }
    if (B[2]>zfar)
        {
        t=(zfar-B[2])/D[2];
        B[0]+=D[0]*t;
        B[1]+=D[1]*t;
        B[2]=zfar;
        }
    // apply perspective
    perspective(A);
    perspective(B);
    // render
    can->MoveTo(A[0],A[1]);
    can->LineTo(B[0],B[1]);
    }