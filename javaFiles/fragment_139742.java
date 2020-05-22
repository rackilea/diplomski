static char[] sequence(char c, int n) {
    char[] ret = new char[n];
    for (int i = 0; i < n; i++)
        ret[i] = c++;
    return ret;
}