public static void main( String[] args ) {
      String test = "Number %1.  And number %2 also.";
      Matcher matcher = Pattern.compile( "%[\\d]+" ).matcher( test );
      ArrayList<String> results = new ArrayList<>();
      while( matcher.find() )
         results.add( matcher.group() );
      System.out.println( results );
   }