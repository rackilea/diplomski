public static void main( String[] args ) {
      final SimpleDateFormat formatter =
         new SimpleDateFormat( "dd MMMMM yyyy - HH:mm a", Locale.US );
      final String dateInString = "23 January 2017 - 02:50 pm";
      try {
         final Date date = formatter.parse(dateInString);
         System.out.println(date);
         System.out.println(formatter.format(date));
      }
      catch( final ParseException e ) {
         e.printStackTrace();
      }
   }