Calendar c1 = Calendar.getInstance();
Calendar c2 = Calendar.getInstance();
// these calendars are equal

CalendarDateWithoutTimeComparator comparator = new CalendarDateWithoutTimeComparator();
System.out.println(comparator.compare(c1, c2));

List<Calendar> list = new ArrayList<Calendar>();
list.add(c1);
list.add(c2);

Collections.sort(list, comparator);