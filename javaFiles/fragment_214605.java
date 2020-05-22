int sz = 1;
int[] h = new int[sz];
sz++;
int h1 = new int[sz];
for (int i = 0; i < h.length;++i) {
  h1[i] = h[i];
}
h = h1;
h[1]=2;
printf("%d",h[1]);