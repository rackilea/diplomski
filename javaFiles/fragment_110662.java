public static double doOperation (double x, double y, char op) {
    switch (op) {
        case '+': return x + y;
        case '-': return x - y;
        case '/': return x/y;
        case '*': return x*y;
    }
    return 0;
}