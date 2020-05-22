int k = 2 * N - 1;
for (int ij = 0; ij < N * (N - 1) / 2; ij++) {
    int i = (int) Math.floor((k - Math.sqrt(k * k - 8 * ij)) / 2);
    int j = i + 1 + ij - (k - i) * i / 2;
    //code
}