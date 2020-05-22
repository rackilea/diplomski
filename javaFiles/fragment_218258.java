public static double exponentiate(double x, int n) 
{ 
    int temp; 
    if(n == 0) 
        return 1; 
    temp = exponentiate(x, n/2); 
    if (n%2 == 0) 
        return temp*temp; 
    else
        return x*temp*temp; 
}