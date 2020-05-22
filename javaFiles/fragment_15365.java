int i, j, k;
for (i = 1; i <= 100; i++) {
   j = (int)(((double)i / 100) * 100);
   if (i != j) {
      printf("%d -> %d\n", i, j);
   }
   k = (int)(((double)i * 100) / 100);
   if (i != k) {
      printf("%d ?? %d\n", i, k);
   }
}