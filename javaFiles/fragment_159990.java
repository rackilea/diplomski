public static void main(String[] args) {
    final String TEST = "InsertedTextAry NO AGREEMENT EXISTS FOR AGENCY - ABCD< 102354 This is test<";
      // Create a Pattern object
    Pattern r = Pattern.compile("NO AGREEMENT EXISTS FOR AGENCY[^<]*");
    if(TEST.contains("NO AGREEMENT EXISTS FOR AGENCY"))
    {
          // Now create matcher object.
          Matcher m = r.matcher(TEST);
          if (m.find( )) {
             System.out.println("Found value: " + m.group(0) );
    }
}