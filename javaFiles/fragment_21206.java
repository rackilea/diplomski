String s = "46:23:12";
String[] values = s.split(":");
// get the hours, minutes and seconds value and add it to the duration
Duration duration = Duration.ofHours(Integer.parseInt(values[0]));
duration = duration.plusMinutes(Integer.parseInt(values[1]));
duration = duration.plusSeconds(Integer.parseInt(values[2]));