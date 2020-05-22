public int f(int n, int ... sequence) {
  int idx = n % sequence.length;
  if (idx < 0) idx += sequence.length;  
  return sequence[idx];
}


int x = f(n, 3,6,9,12);