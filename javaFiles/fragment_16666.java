public static double eTwo(double x, long n){
    if(n==0)
        return 1;
    else 
        return eTwo(x,n-1) + Math.pow(x, n)/factorial(n);
}

public double factorial (n){
    if(n==0)
        return 1;
    else 
        return n*factorial(n-1);
}