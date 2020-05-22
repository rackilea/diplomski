public static void main(String[] args)
{
   String line = //..read a line from STDIN

   //check for special characters 
   if(line.equals(SpecialChars.COMMA)      
      || line.equals(SpecialChars.APOSTROPHE)
      || line.equals(SpecialChars.OPEN_PAREN) 
      || line.equals(SpecialChars.CLOSE_PAREN)
   ) {
        //do something for the special chars
   }
}