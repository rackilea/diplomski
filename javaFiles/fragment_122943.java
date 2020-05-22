long l1 = LocalDateTime.of(LocalDate.of(2037, 3, 29), LocalTime.of(1, 00, 01))
                       .atZone(ZoneId.of("UTC")).toInstant().getEpochSecond()*1000;
long l2 = LocalDateTime.of(LocalDate.of(2038, 3, 28), LocalTime.of(1, 00, 01))
                       .atZone(ZoneId.of("UTC")).toInstant().getEpochSecond()*1000;

TimeZone zone=TimeZone.getTimeZone("Europe/Berlin");
Field table=zone.getClass().getDeclaredField("transitions");
table.setAccessible(true);
System.out.println("table length="+((long[])table.get(zone)).length);

Method getTransitionIndex = zone.getClass()
    .getDeclaredMethod("getTransitionIndex", long.class, int.class);
getTransitionIndex.setAccessible(true);
final Integer UTC_TIME = 0;
int indexFor2037 = (Integer)getTransitionIndex.invoke(zone, l1, UTC_TIME);
System.out.println("index for 2037="+indexFor2037);
int indexFor2038 = (Integer)getTransitionIndex.invoke(zone, l2, UTC_TIME);
System.out.println("index for 2038="+indexFor2038);