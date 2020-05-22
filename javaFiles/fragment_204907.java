public static int recursion(int big, int small) {
    int remainder = big % small;
    if(remainder == 0) {
        return small;
    } else {
        return recursion(small,remainder);
    }
}