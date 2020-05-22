DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm",
                                         Locale.US);
System.out.println("Enter date and time in the format yyyy-MM-ddTHH:mm");
System.out.println("For example, it is now " + format.format(new Date()));
Date date = null;
while (date == null) {
    String line = scanner.nextLine();
    try {
        date = format.parse(line);
    } catch (ParseException e) {
        System.out.println("Sorry, that's not valid. Please try again.");
    }
}