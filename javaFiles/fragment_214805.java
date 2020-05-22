long startTimestamp = getStartTimestamp();
ZoneId zoneId = ZoneId.systemDefault();

ZonedDateTime maxDateTime = Instant.ofEpochMilli(maxTimestamp).atZone(zoneId);
ZonedDateTime loopDateTime = Instant.ofEpochMilli(loopTs).atZone(zoneId);

while (!loopDateTime.isAfter(maxDateTime)) {
    tsList.add(loopDateTime.toInstant().toEpochMilli());
    loopDateTime = loopDateTime.plusDays(1);
}