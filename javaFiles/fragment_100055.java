public static boolean check(int[] digits) {
 int sum = 0;
 int length = digits.length;
 for (int i = 0; i < length; i++) {

   // get digits in reverse order
   int digit = digits[length - i - 1];

   // every 2nd number multiply with 2
   if (i % 2 == 1) {
       digit *= 2;
   }
   sum += digit > 9 ? digit - 9 : digit;
 }
 return sum % 10 == 0;