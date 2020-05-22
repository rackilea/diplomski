//a---->b Fourier Transformation brute-force
__kernel void dft(__global float *aRe,
                  __global float *aIm,
                  __global float *bRe,
                  __global float *bIm)
{
    int id=get_global_id(0); // thread id
    int s=get_global_size(0); // total threads = 512
    double cRe=0.0f;
    double cIm=0.0f;
    double fid=(double)id;
    double fmpi2n=(-2.0*M_PI)*fid/(double)s;
    for(int i=0;i<s;i++)
    {
            double fi=(float)i;
            double re=cos(fmpi2n*fi);
            double im=sin(fmpi2n*fi);

            cRe+=aRe[i]*re-aIm[i]*im;
            cIm+=aRe[i]*im+aIm[i]*re;
    }

    bRe[id]=cRe;
    bIm[id]=cIm;
}