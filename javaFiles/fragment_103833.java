static int solution(int n) {
    return solution(n >>> Integer.numberOfTrailingZeros(n), 0, 0);
}

static int solution(int n, int max, int current) {
    if (n == 0)
        return max;
    else if ((n & 1) == 0)
        return solution(n >>> 1, max, current + 1);
    else
        return solution(n >>> 1, Math.max(max, current), 0);
}