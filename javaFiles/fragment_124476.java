private static int func(int x, int y) {
    if (x >= arrlist.length)
        return 0;
    int self = arrlist[x][y];
    if (isPrime(self))
        return 0;
    else
        return self + Math.max(func(x + 1, y), func(x + 1, y + 1));
}