double[] m = new double[n/2 + 1];

boolean isOdd = ((n % 2) == 1);
if (isOdd) {
  // odd case
  m[0] = abs(a[0]);
  for (int i = 1; i < (n-1)/2; i++) {
    m[i] = sqrt(a[2*i]*a[2*i] + a[2*i+1]*a[2*i+1]);
  }
  m[(n-1)/2] = sqrt(a[n-1]*a[n-1] + a[1]*a[1]);
} else {
  // even case
  m[0] = abs(a[0]);
  for (int i = 1; i < n/2; i++) {
    m[i] = sqrt(a[2*i]*a[2*i] + a[2*i+1]*a[2*i+1]);
  }
  m[n/2] = abs(a[1]);
}