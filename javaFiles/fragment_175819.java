int i,n,y=12; double x=10000.00,fy=y,z,D,d,s;
z=floor((100.0*x)/fy)*0.01;         // cell value rounded
D=x-(z*fy);                         // global correction
n=floor((100.0*D)+0.5);             // iregular remainder
for (s=0.0,i=0;i<y;i++)
    {
    d=0.01*floor(100.0*D/y);        // regular local correction
    if (i<n) d+=0.01;               // iregular local correction
    // z+d is the new cell value and s is the sum for check ...
    s+=z+d;
    mm_log->Lines->Add(AnsiString().sprintf("%3i: %5.2f",i,z+d));
    }
mm_log->Lines->Add("--------------");
mm_log->Lines->Add(AnsiString().sprintf("sum: %5.2f",s));