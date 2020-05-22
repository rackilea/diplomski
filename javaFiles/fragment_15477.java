function exp(c,n){
    // throw exception when n is not an natural number or 0
    if(n == 0){
        return 1;
    }
    m = exp(c, floor(n/2));
    if (n % 2 == 0){
        return m*m;
    } else{
        return m*m*c;
    }
}