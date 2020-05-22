public static void main(String[] args) {
     DateTime start = new DateTime();
     DateTime end;
     if(start.getDayOfMonth()>24 && start.getMonthOfYear()==12)
     {
         end = new DateTime(start.getYear()+1, 12, 25, 0, 0, 0);
     }
     else
     {
         end = new DateTime(start.getYear(), 12, 25, 0, 0, 0);
     }
      Seconds diff = Seconds.secondsBetween(start, end);
      System.out.println(diff.getSeconds());

}