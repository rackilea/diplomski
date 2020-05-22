public static double mathPower(double a, int b) 
{
    double result = 1;

    if (b < 0) {
       a = 1.0 / a;
       b = -b;
    }

    for (int  i = 0; i < b; i++) {
        result = result * a;
    }

    return result;
}