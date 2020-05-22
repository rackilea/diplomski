private static DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
private static DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");

public void setyourDate(String yourDate) {
Date date2;
yourDate = getyourDate() + "" + yourDate;
try {
date2 = df.parse(yourDate);
yourDate = df2.format(date2);

} catch (ParseException e) {
}
this.yourDate = yourDate;
}