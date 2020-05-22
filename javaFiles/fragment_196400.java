int res = -1;
int min_value = A[0];
for(int i=1; i<N; i++) {
    // A[i] - A[j] is maximal, when A[j] is minimal value from {A[0], A[1],.., A[i-1]}
    res = max(res, A[i] - min_value);
    min_value = min(min_value, A[i]);
}
return res;