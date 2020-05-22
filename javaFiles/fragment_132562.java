DateFormatSymbols englishSymbols = DateFormatSymbols.getInstance(Locale.ENGLISH);
 DateFormatSymbols mySymbols = (DateFormatSymbols)englishSymbols.clone();
 String[] weekdays = mySymbols.getWeekdays();
 weekdays[Calendar.SUNDAY] = "Sunnyday";
 mySymbols.setWeekdays(weekdays);
 DateFormat f = new SimpleDateFormat("EEEE, dd MMM, yyyy", mySymbols);

 System.out.println(f.format(new Date()));