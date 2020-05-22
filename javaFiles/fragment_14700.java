public static String[] addToArray(final String[] source, final String element) {
   final String[] destination = new String[source.length + 1];
   System.arraycopy(source, 0, destination, 0, source.length);
   destination[source.length] = element;
   return destination;
}