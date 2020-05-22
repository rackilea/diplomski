private static boolean isValidNumber(String strContact) {
   for (int i = 0; i < strContact.length(); i++) {
      if (!Character.isDigit(strContact.charAt(i))) {
         return false;
      }
   }

   return true;
}