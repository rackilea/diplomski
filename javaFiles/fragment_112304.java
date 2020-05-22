DateFormat df;

if (locale.equals(myLocale)) {
  df = new SimpleDateFormat("dd/MM/yy HH:mm"); // yy for 2-digit-year, not YY!
} else {
  // general solution for other locales
  df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, myLocale);
}