public boolean isHex(String testString) {


   If String has 0 characters -> return true;

   Else

      If first character is a hex character -> call isHex with the remaining characters

      Else if the first character is not a hex character -> return false;

}