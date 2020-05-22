for (int i = 0; i < decimals; i++) {
     remainder *= 100;
     int base = Integer.parseInt(ans) * 20;
     //Now check digits
     for (int j = 9; j >= 0; j--) {
          int trial = (base + j) * j; //Use the digit
          if (trial < remainder) {
               //We have found the first digit that is less than the remainder!
               remainder -= trial;
               ans += j;
               break;
          }
     }
}