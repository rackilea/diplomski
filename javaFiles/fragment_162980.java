static void timeCombinations(String startTime, String endTime) 
{
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
  LocalTime end = LocalTime.parse(endTime);
  for(LocalTime t=LocalTime.parse(startTime); t.isBefore(end); t=t.plusSeconds(1))
  {
    System.out.println(dtf.format(t));
  }
  System.out.println(end);
}