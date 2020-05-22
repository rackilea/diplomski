// Bad implementation of rounding up to nearest 10 by mutating box
public int test(int[] n) {
  if( n[0] % 10 == 0)
    return n[0];
  n[0]++; // mutates array not binding
  return test(n);
}