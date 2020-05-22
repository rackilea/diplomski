private enum SpecialChars{
   COMMA(","),
   APOSTROPHE("'"),
   OPEN_PAREN("("),
   CLOSE_PAREN(")");

   private String value;
   private SpecialChars(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; //will return , or ' instead of COMMA or APOSTROPHE
   }
}