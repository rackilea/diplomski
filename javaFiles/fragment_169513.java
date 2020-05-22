SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
Date ten = parser.parse("10:00");
Date eighteen = parser.parse("18:00");

try {
    Date userDate = parser.parse(someOtherDate);
    if (userDate.after(ten) && userDate.before(eighteen)) {
        ...
    }
} catch (ParseException e) {
    // Invalid date was entered
}