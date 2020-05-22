ArrayList<Date> dates = new ArrayList<>();
for (String dateString : dateStrings) {
    try {
        dates.add(dateFormat.parse(dateString));
    } catch (ParseException e) {
        System.out.println(e);
    }
}