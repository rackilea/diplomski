private static boolean condition(int n){
    for (int i = 0; i <= n; i++)
        if(n == i*4 || n == (i * 4 - 1))
            return true;
    return false;
}

public static double recursiveVal(int x, int y, double A, double B){

    if (x > 6 && (x - 2 >= y))
        return 1;

    if (y > 6 && (y - 2 >= x))
        return 0;

    if(x > 5 && y > 5 && x == y)
        return A*(1-B) / (1 -(A*B) - ((1-A)*(1-B)));

    double val1 = recursiveVal(x+1, y, A, B);
    double val2 = recursiveVal(x, y+1, A, B);

    return condition(x + y)
        ? A * val1 + val2 * (1-A)
        : (1-B) * val1 + B * val2; 
}