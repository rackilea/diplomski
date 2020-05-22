try {
  String date = "2014-11-1T12:14:00";
  Date convertedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date);
  System.out.println(convertedDate.toString());
  // Per your comment you wanted to `format()` it like -
  System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(convertedDate));
} catch (ParseException p) {
  System.err.println(p.getMessage());
}