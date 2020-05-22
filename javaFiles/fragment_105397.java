public static int multiply(int x, int y){
    if(x==y){
        return x;
    }
    if(x == y-1){
        return x*y;
    }
    int product = x*y;
    product = product*multiply(x+1,y-1);
    return product;
}