if(x > width/2)
{
    float clipFraction = (width/2) / x; // amount to shorten the vector
    x *= clipFraction;
    y *= clipFraction;
}
else if(x < -width/2)
{
    float clipFraction = (-width/2) / x; // amount to shorten the vector
    x *= clipFraction;
    y *= clipFraction;
}