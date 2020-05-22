public static boolean zeroCheck(double numberTwo, String operator) {    
   if (numberTwo == 0) {      
      if (operator == "/" || operator == "%") {
         System.out.println("You cannot use a zero to divide or mod.");
      }
      return false;
   } else return true
}