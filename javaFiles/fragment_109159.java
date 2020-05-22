public int gujarati (String str) {
     int len = str.length ();
     int sum = 0;
     for (int i=0; i < len; i++) {
         sum += (str.charAt (i) - 2790 ) * Math.pow (10, len - i - 1);
     }
     return sum;
 }