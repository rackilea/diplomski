public static void main(String[] args) throws ParseException {
    // Define the corresponding format
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Calendar startCalendar = Calendar.getInstance();
    // Parse "31.07.2016" and set the resulting date to the calendar instance
    startCalendar.setTime(format.parse("31.07.2016"));
    // Print the formatted date
    System.out.println(format.format(startCalendar.getTime()));
}