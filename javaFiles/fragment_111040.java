// prepare parser
ChronoFormatter<PlainTimestamp> f = 
  ChronoFormatter.ofTimestampPattern( // five decimal digits
    "uuuu-MM-dd HH:mm:ss.SSSSS", PatternType.CLDR, Locale.ROOT);

// parse input to intervals - here the overall time window
TimestampInterval timeline = 
  TimestampInterval.between(
    f.parse("2016-01-01 10:00:00.00000"), 
    f.parse("2016-02-01 09:00:00.00000"));

// for more flexibility - consider a for-each-loop
TimestampInterval i1 =
    TimestampInterval.between(f.parse("2016-01-01 10:00:00.00000"), f.parse("2016-01-01 11:00:00.00000"));
TimestampInterval i2 =
    TimestampInterval.between(f.parse("2016-01-01 11:00:00.00000"), f.parse("2016-01-01 12:00:00.00000"));
TimestampInterval i3 =
    TimestampInterval.between(f.parse("2016-01-01 13:00:00.00000"), f.parse("2016-01-01 13:30:00.00000"));
TimestampInterval i4 =
    TimestampInterval.between(f.parse("2016-01-01 13:30:00.00000"), f.parse("2016-01-01 14:30:00.00000"));
TimestampInterval i5 =
    TimestampInterval.between(f.parse("2016-01-01 15:30:00.00000"), f.parse("2016-01-01 16:30:00.00000"));
TimestampInterval i6 =
    TimestampInterval.between(f.parse("2016-01-01 16:30:00.00000"), f.parse("2016-01-01 17:00:00.00000"));

// apply interval arithmetic
IntervalCollection<PlainTimestamp> icoll =
    IntervalCollection.onTimestampAxis().plus(Arrays.asList(i1, i2, i3, i4, i5, i6));
List<ChronoInterval<PlainTimestamp>> missed = icoll.withComplement(timeline).getIntervals();

// result
System.out.println(missed); 
// [[2016-01-01T12/2016-01-01T13), [2016-01-01T14:30/2016-01-01T15:30), [2016-01-01T17/2016-02-01T09)]