String input = "07/18/2018 01:00-04:00 CDT";

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm z");

// parse 07/18/2018 01:00 CDT
ZonedDateTime first = ZonedDateTime.parse(input.replaceAll("-\\d{2}:\\d{2}", ""), formatter); 

// parse 07/18/2018 04:00 CDT
ZonedDateTime second = ZonedDateTime.parse(input.replaceAll("\\d{2}:\\d{2}-", ""), formatter);