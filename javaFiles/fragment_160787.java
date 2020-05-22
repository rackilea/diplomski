static boolean anyMatch(int find, int... in) {
    for (int n : in)
        if (n == find)
            return true;
    return false;
}
// ...
if (anyMatch(1, firstDigit, secondDigit, ...))