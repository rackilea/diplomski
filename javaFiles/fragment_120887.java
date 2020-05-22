Instant now = Instant.now();
Instant ago = Instant.ofEpochSecond(1234567890L);

System.out.println(ChronoUnit.YEARS.between(
  ago.atZone(ZoneId.systemDefault()),
  now.atZone(ZoneId.systemDefault())));