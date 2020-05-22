public static int persistence(long n) {
    if(n < 10) return 0;
    long num = 1;
    while(n != 0) {
        num*=(n % 10);
        n/=10;
    } 
    if (num > 10) {
        return 1 + persistence (num);
    } else {
        return 1;
    }
}