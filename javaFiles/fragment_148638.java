import static java.lang.Math.abs;

public static long roundUp(long num, long divisor) {
    int sign = (num > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
    return sign * (abs(num) + abs(divisor) - 1) / abs(divisor);
}