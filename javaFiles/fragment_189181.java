int multiply(int a, int b) {
    if (a == 0 || b == 0) {
        return 0;
    } 
    return b + multiply(a - 1, b);
}