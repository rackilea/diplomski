public static int factorial(int n){
    int max = 1;
    for (int p=2; p<=n ; p++){
        max *= p;
    }
    return max;
}