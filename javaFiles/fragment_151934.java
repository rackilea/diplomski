int add(int a, int b) {
   if (b == 0) {
     // exit condition, b is zero
     return a;
   } else if (b > 0) {
     // moving b closer to zero
     return add(a+1, b-1);
   } else {
     // b is negative, moving b closer to zero
     return add(a-1, b+1);
   }
 }