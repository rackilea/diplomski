int solution(int A, int B, int K) {
    const int firstDividableInRange = A % K == 0 ? A : A + (K - A % K);
    const int lastDividableInRange = B - B % K;
    const int result = (lastDividableInRange - firstDividableInRange) / K + 1;

return result;
}