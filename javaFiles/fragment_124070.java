ArrayList<ArrayList<DriverLogDatePair>> driverLogList = new ArrayList<>();
Collections.sort( driverLogList, new Comparator<ArrayList<DriverLogDatePair>>(){
   @Override public int compare(
      ArrayList<DriverLogDatePair> left,
      ArrayList<DriverLogDatePair> right )
   {
      return 0;
   }});