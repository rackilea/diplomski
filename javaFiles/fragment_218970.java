public static double Sumto(int n)
  {
    if (n == 0) { return 0.0; }
    else if (n > 0) { return 1.0/n + Sumto(n - 1); }
    else { throw new IllegalArgumentException("Please provide positive integers"); }
  }