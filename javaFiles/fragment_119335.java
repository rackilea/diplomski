// prints 2011-11-28
   public static  void  main(String[] args) throws Exception {
        LocalDate today = new LocalDate(2011,11,27);
        int dow = DateTimeConstants.MONDAY;
        System.out.println(getNearestDayOfWeek(today ,dow ));
   }