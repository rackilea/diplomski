/**
     * @param args
     */
    public static void main(String[] args) {

         java.util.Date date= new java.util.Date();

         //date to String
         String dateToString = date.toString();

         System.out.println("Date to String:      "+ dateToString);

         //formated date as String
         new SimpleDateFormat();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String dateAsString = sdf.format(date);

         System.out.println("Formatted date:      "+ dateAsString);

         //time stamp to string
         Timestamp timeStamp = new Timestamp(date.getTime());
         String timeStampToString = timeStamp.toString();

         System.out.println("Timestamp to String: "+ timeStampToString);
    }