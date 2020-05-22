String originalRecurrenceRule = "FREQ=WEEKLY;INTERVAL=1;BYDAY=FR;WKST=MO;UNTIL=20160731T223030Z;";
String until = originalRecurrenceRule.substring(originalRecurrenceRule.indexOf("UNTIL"), originalRecurrenceRule.indexOf(";", originalRecurrenceRule.indexOf("UNTIL")));
SimpleDateFormat sdf = new SimpleDateFormat();
Date date = sdf.parse(until.substring(until.indexOf("=") + 1),until.length() - 1);
date.setTime(timeInMilliseconds);
originalRecurrenceRule.replace(until, "UNTIL="+ date.toString() + ";");