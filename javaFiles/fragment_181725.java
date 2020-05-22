// a--->b inverse Fourier Transformation brute force
__kernel void idft(__global float *aRe,
                   __global float *aIm,
                   __global float *bRe,
                   __global float *bIm)
{
    int id=get_global_id(0); // thread id
    int s=get_global_size(0); // total threads = 512
    double cRe=0.0f;
    double cIm=0.0f;
    for(int i=0;i<s;i++)
    {
        double re=cos(2.0*M_PI*((double)id)*((double)i)/(double)s);
        double im=sin(2.0*M_PI*((double)id)*((double)i)/(double)s);

        cRe+=aRe[i]*re-aIm[i]*im;
        cIm+=aRe[i]*im+aIm[i]*re;
    }
    cRe/=(double)s;
    cIm/=(double)s;
    bRe[id]=cRe;
    bIm[id]=cIm;
}