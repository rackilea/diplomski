DateTimeField dayOfWeek = ISOChronology.getInstance().dayOfWeek();

System.out.println(dayOfWeek.getAsText(DateTimeConstants.MONDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.TUESDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.WEDNESDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.THURSDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.FRIDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.SATURDAY, Locale.ENGLISH));
System.out.println(dayOfWeek.getAsText(DateTimeConstants.SUNDAY, Locale.ENGLISH));