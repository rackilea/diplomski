public int noTeenSum(int a, int b, int c) {
 return fixTeen(a)+fixTeen(b)+fixTeen(c);
}

public int fixTeen(int x) {
 if(x<=12||x>=20||x==15||x==16)
  return x;
 return 0;
 }