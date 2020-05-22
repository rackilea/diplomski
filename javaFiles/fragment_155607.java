int factorial(int n){
    if ( n == 1 ){ //the base case is when n = 1
        return 1;
    }
    return n*factorial(n-1);
}