static int pagesTurnCount(int n, int p) {
    n /= 2; // >>= 1
    p /= 2;
    return Math.min(p, n - p); // From front, from back
}

       p
 0  >  1  <  2  <  3      page pairs
- 1   2 3   4 5   6 -     pages