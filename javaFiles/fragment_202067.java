double f(double t) {
  double f = 0;
  for (int i = 0; i < N; ++i) {
    f += A[i] * cos(i * t + w[i]);
  }
  return f;
}