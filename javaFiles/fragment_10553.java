public static void main(String[] args) {
  // The format.
  DateFormat sdf = new SimpleDateFormat("yy.MM.dd");
  Date theDate = new Date(); // a date.
  String dateStr = sdf.format(theDate); // to a String. dateStr for example.
  System.out.println(dateStr); // Print it out.
}