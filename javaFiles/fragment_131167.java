class Test
 {

     public static void main(String[] args) throws ParseException {
         SimpleDateFormat f = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss");
         String string_date = "Wed Sep 17 2014 12:44:22";
         System.out.println(f.parse(string_date));

     }

  }