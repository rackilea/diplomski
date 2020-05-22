Range<Date> a = Range.closed(
    new GregorianCalendar(2015, 0, 1).getTime(),
    new GregorianCalendar(2015, 0, 20).getTime());
Range<Date> b = Range.closed(
    new GregorianCalendar(2015, 0, 5).getTime(),
    new GregorianCalendar(2015, 0, 10).getTime());
Range<Date> c = Range.closed(
    new GregorianCalendar(2015, 0, 11).getTime(),
    new GregorianCalendar(2015, 0, 14).getTime());
Range<Date> d = Range.closed(
    new GregorianCalendar(2015, 0, 19).getTime(),
    new GregorianCalendar(2015, 0, 25).getTime());

RangeSet<Date> result = TreeRangeSet.create();
result.add(a);
result.remove(b);
result.remove(c);
result.add(d);

System.out.println(result);