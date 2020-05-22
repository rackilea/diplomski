int x = //...
  DateTime dateFrom = new DateTime(/* ... */);
  DateTime dateTo = new DateTime(/* ... */);
  long singlePart = (dateTo.getMillis() - dateFrom.getMillis()) / x;
  List<Interval> result = new ArrayList<Interval>();

  for (int i = 0; i < x; i++)
  {
     result.add(new Interval(dateFrom.plusMillis((int) singlePart * i), dateFrom.plusMillis((int) singlePart * (i + 1))));      
  }