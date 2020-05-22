public static int reverse(int x){
    int y = 0;//create the reveresed number here
    while(x!=0){
        y = y * 10 + x % 10;
        x/=10;
    }
    return y;
}