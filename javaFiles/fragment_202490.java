static final double threshold = 0.000001;

//finds root; returns null if none is found
static Double findaroot(double x1, double x2)
{
    if(  Math.signum( f(x1,0) ) == Math.signum( f(x2,0) )  )
    {
        return null;
    }
    else
    {
        if(Math.abs(x1-x2)<=threshold)
        {
            return x1;
        }
        else
        {
            return Math.min( findaroot(x1,(x1+x2)/2) , findaroot((x1+x2)/2,x2));
        }
    }
}