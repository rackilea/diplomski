public static int prod (int m, int n) {
   if (m == 0) {
     return n+1;
   } else if(m>0 && n == 0) {
     return prod (m-1, 1);
   } else if(m>0 && n >0) {
     return prod(m-1,prod(m,n-1));
   }

   return n;
}