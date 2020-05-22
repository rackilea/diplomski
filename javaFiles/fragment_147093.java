public static List<String> customSplit(String input) {
   List<String> elements = new ArrayList<String>();       
   StringBuilder elementBuilder = new StringBuilder();

   boolean isQuoted = false;
   for (char c : input.toCharArray()) {
     if (c == '\"') {
        isQuoted = !isQuoted;
        // continue;        // changed according to the OP comment - \" shall not be skipped
     }
     if (c == ',' && !isQuoted) {
        elements.add(elementBuilder.toString().trim());
        elementBuilder = new StringBuilder();
        continue;
     }
     elementBuilder.append(c); 
   }
   elements.add(elementBuilder.toString().trim()); 
   return elements;
}