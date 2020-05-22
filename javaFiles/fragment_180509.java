private static boolean odd(boolean x, boolean y, boolean z) {
    int sum = 0;
    if(x) sum++;
    if(y) sum++;
    if(z) sum++;

    // check if its odd.
    return sum % 2 != 0;
}