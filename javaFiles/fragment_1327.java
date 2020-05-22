public static boolean prime (int num) {
    int t = 2;
    while (t * t <= num) {
        if ((num % t) == 0) {
            return false;
        }
        t++;
    }
    return true;
}