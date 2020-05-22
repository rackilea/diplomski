double f(double t) {
  double f = 0;
  for (int i = 0; i < N; ++i) {
    f += A[i] * exp(-Math.pow(t-w[i], 2) / sigma[i]);
  }
  return f;
}