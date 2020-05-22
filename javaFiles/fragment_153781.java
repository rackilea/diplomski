public static <T extends Tool> T getInstance(Class<T> toolClass) {
   if (Parser.class.isAssignableFrom(toolClass) {
      return new ParserImpl();
   }
   else if (Converter.class.isAssignableFrom(toolClass) {
      return new ConverterImpl();
   }

   // You'll always need to have a catch-all case else the compiler will complain
   throw new IllegalArgumentException("Unknown class: " + toolClass.getName());
}