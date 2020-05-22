public class TimeConverter implements Converter<Time, OffsetTime> {
  @Override public OffsetTime from(Time time) {
    return time == null ? null : OffsetTime.ofInstant(Instant.ofEpochMilli(time.getTime()), ZoneOffset.systemDefault());
  }
  @Override public Time to(OffsetTime offsetTime) {
    return offsetTime == null ? null : new Time(offsetTime.atDate(LocalDate.ofEpochDay(0)).toInstant().toEpochMilli());
  }
  @Override public Class<Time> fromType() { return Time.class; }
  @Override public Class<OffsetTime> toType() { return OffsetTime.class; }
}