String input = "2011120312345655"; 
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
int len = input.length();
LocalDateTime ldt = LocalDateTime.parse(input.substring(0, len - 2),  dtf);
int millis = Integer.parseInt(input.substring(len - 2)) * 10;
ldt = ldt.plus(millis, ChronoUnit.MILLIS);
System.out.println(ldt); // 2011-12-03T12:34:56.550