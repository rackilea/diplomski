String[] capitalDays = {
    "", "SUN", "MON",
    "TUE", "WED", "THU",
    "FRI", "SAT"
};
symbols = new DateFormatSymbols( new Locale("en", "US"));
symbols.setShortWeekdays(capitalDays);

formatter = new SimpleDateFormat("E", symbols);
result = formatter.format(new Date());
System.out.println("Today's day of the week: " + result);