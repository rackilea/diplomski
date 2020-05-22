final DateFormat df = DateFormat.getDateTimeInstance();
final Calendar c = Calendar.getInstance();
c.clear();
for (c.set(2011, Calendar.JANUARY, 1, 0, 0, 0);
     c.get(Calendar.YEAR) == 2011;
     c.add(Calendar.HOUR_OF_DAY, 1))
  System.out.println(df.format(c.getTime()));