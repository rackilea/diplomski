public List<List<Date>> returnTwoArrayList()
   {
      List<Date> startDates = new ArrayList<Date>();
      List<Date> endDates = new ArrayList<Date>();

      List<List<Date>> result = new ArrayList<List<Date>>();
      result.add(startDates);
      result.add(endDates);

      return result;
   }