public static double z(double i)
{
    if(i < 1)
    {
        //error
    }
    else if(i == 1)
    {
        return C;  // where C is some arbitrary constant, your base case: Z(1);
    }
    else
    {
        return sqrt(2 + z(i-1));
    }

}