final int h = 4;
 final int w = 3;
 for (int d = 0; d < w + h; d++) {
     for (int y = 0; y < h; y++) {
         int x = w - d + y;
         if (x < 0 || x >= w) continue;
         System.out.printf("%d %d\n", x, y);
     }
 }