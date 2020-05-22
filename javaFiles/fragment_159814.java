class Custom {
   private final String input;

   public Custom(String input) {
      this.input = input;
   }

   // not needed but implemented for completeness    
   public static Custom parse(String input) {
      return new Custom(input);
   }
}