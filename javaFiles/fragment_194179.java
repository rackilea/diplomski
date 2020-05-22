public static ExitCodes getByID(int id) {
   for (final ExitCodes element : EnumSet.allOf(ExitCodes.class)) {
    if (element.id == id) {
      return element;
    }
   }

   throw new IllegalArgumentException("Can't find " + id);
}