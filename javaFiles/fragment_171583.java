public static int gCd(int x, int y) {
     if(y == 0) {
         return x;
     }
     return gCd(y, x%y);
 }