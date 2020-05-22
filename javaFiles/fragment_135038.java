public int reverse(int x) { 
    byte TEN = 10; 
    long rev = 0;
    if (x != 0) {
        int sign = x < 0 ? -1 : +1;
        do {
            rev = TEN * rev + (x % 10);
            x /= 10;
        } while (x * sign > 0);     
    }     
    if (rev > 2147483647 || rev < -2147483648) {
        return 0;
    } 
    return (int) rev;
}