public static int factorial2(int n) {
    int i = 1; 
    while (n > 1) {
        i = i * n;
        n--;
    }
    return i;
}