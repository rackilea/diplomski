public static boolean checkPrime(int n){
    int x = 2;
    while (((n % x) != 0) && (n > x)){
        x = x + 1;
    }
    if(((n % x) == 0) && (n == x)){     
        return !(PrimeOrNot);
    }
    return (PrimeOrNot);
}