private static int factorialRecursive(int num) {
    // Warning here use || instead of |
    if (num==1 || num==0)
        return 1;
    return num * factorialRecursive(num - 1);
}