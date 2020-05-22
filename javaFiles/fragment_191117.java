ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
// this would be the today (might be in the past)
ZonedDateTime result = now.with(LocalTime.of(17, 0));
if (result.isBefore(now)) {
  // This would be "next time it is 5 o-clock".
  result = result.plusDays(1);
}
// if you really want an Instant out of it.
return result.toInstant();