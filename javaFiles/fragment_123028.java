DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
Calendar cal = Calendar.getInstance();
try {
    cal.setTime(sdf.parse(String.format("%s %s", date, time)));
    // use cal....
} catch (ParseException e) {
    e.printStackTrace();
}