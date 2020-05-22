bool is_pnt_in_segment(double x,double y,int segment,int segments) 
 {
 double a;
 a=atanxy(x-x0,y-y0); // get sweep angle
 a/=2.0*M_PI; // convert angle to a = <0,1>
 if (a>=1.0) a=0.0; // handle extreme case where a was = 2 Pi
 a*=segments; // convert to segment index a = <0,segments)
 a-=double(segment );
 // return floor(a); // this is how to change this function to return points segment id
 // of course header should be slightly different: int get_pnt_segment_id(double x,double y,int segments) 
 if (a< 0.0) return false; // is lower then segment
 if (a>=1.0) return false; // is higher then segment
 return true;
 }