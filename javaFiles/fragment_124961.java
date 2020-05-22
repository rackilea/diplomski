final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
try {
    final Date fromDate = dateFormat.parse(from_date);
} catch (ParseException e) {
    // ...
}