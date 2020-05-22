public enum SpecialCharacterField{
   PLUS("+"),
   HASH("#");

   private String value;
   private SpecialCharacterField(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; //This will return , # or +
   }
}