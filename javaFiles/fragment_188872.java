private static final double xToAz = 5.0/0.18;    

onChange(x)
{        
    az = xToAz * x;
    az -= az%5;
}