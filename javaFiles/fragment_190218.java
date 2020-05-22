double x0,y0,rx,ry; // ellipse parameters

// [Edit2] sorry forgot to add these constants but they are I thin straight forward
const double pi=M_PI;
const double pi2=2.0*M_PI;
// [/Edit2]

double atanxy(double x,double y) // atan2 return < 0 , 2.0*M_PI >
        {
        int sx,sy;
        double a;
        const double _zero=1.0e-30;
        sx=0; if (x<-_zero) sx=-1; if (x>+_zero) sx=+1;
        sy=0; if (y<-_zero) sy=-1; if (y>+_zero) sy=+1;
        if ((sy==0)&&(sx==0)) return 0;
        if ((sx==0)&&(sy> 0)) return 0.5*pi;
        if ((sx==0)&&(sy< 0)) return 1.5*pi;
        if ((sy==0)&&(sx> 0)) return 0;
        if ((sy==0)&&(sx< 0)) return pi;
        a=y/x; if (a<0) a=-a;
        a=atan(a);
        if ((x>0)&&(y>0)) a=a;
        if ((x<0)&&(y>0)) a=pi-a;
        if ((x<0)&&(y<0)) a=pi+a;
        if ((x>0)&&(y<0)) a=pi2-a;
        return a;
        }