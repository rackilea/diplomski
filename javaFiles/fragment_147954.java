try {
  DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  DateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy");
  return df2.format(df1.parse(input));
}
catch (ParseException e) {
  return null;
}