object JodaTime {
  def mkInterval(start: ReadableInstant, end: ReadableInstant) = new Interval(start, end)
  def unmkInterval(interval: Interval) = Some((interval.getStart, interval.getEnd))
}

// elsewhere
mapping(
  "start" -> jodaDate,
  "end" -> jodaDate,
)(JodaTime.mkInterval)(JodaTime.unmkInterval)