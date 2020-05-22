void draw_plane_xz(TCanvas *can,double y,double step) // draw 3D plane
    {
    int i;
    double A[3],B[3],t,size;
    double U[3]={1.0,0.0,0.0};  // U = X
    double V[3]={0.0,0.0,1.0};  // V = Z
    double O[3]={0.0,0.0,0.0};  // Origin
    // compute origin near view center but align to step
    i=0; O[i]=floor(camera[12+i]/step)*step;
    i=2; O[i]=floor(camera[12+i]/step)*step;
    O[1]=y;
    // set size so plane safely covers whole view
    t=xs2*zfar/znear;               size=t; // x that will convert to xs2 at zfar
    t=0.5*(zfar+znear); if (size<t) size=t; // half of depth range
    t+=step;                                // + one grid cell beacuse O is off up to 1 grid cell
    t*=sqrt(2);                             // diagonal so no matter how are we rotate in Yaw
    // U lines
    for (i=0;i<3;i++)
        {
        A[i]=O[i]+(size*U[i])-((step+size)*V[i]);
        B[i]=O[i]-(size*U[i])-((step+size)*V[i]);
        }
    for (t=-size;t<=size;t+=step)
        {
        for (i=0;i<3;i++)
            {
            A[i]+=step*V[i];
            B[i]+=step*V[i];
            }
        draw_line(can,A,B);
        }
    // V lines
    for (i=0;i<3;i++)
        {
        A[i]=O[i]-((step+size)*U[i])+(size*V[i]);
        B[i]=O[i]-((step+size)*U[i])-(size*V[i]);
        }
    for (t=-size;t<=size;t+=step)
        {
        for (i=0;i<3;i++)
            {
            A[i]+=step*U[i];
            B[i]+=step*U[i];
            }
        draw_line(can,A,B);
        }
    matrix_mul_vector(A,icamera,A);
    }