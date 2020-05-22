static final int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4,
  6, 2, 4 };

static int dow(int y, int m, int d) {
  if (m < 3) {
    y--;
  }
  return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
}