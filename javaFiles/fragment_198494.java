int[] top = new int[A.length];
int max = -Integer.MAX_VALUE;
for (int i=A.length-1; i>=0; i--) {
    if (A[i] > max) max = A[i];
    top[i] = max;
}