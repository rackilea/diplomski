public static void main(String[] args) throws ParseException {
  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  String[] dates = { "12/2/2010", "12/3/2010", "12/5/2010", "12/10/2010", "12/5/2010", "12/13/2010", "12/14/2010", "12/12/2010" };
  Set<String> weekends = new HashSet<String>();
  for (String dt : dates) {
    Date date = dateFormat.parse(dt);
    if (isWeekend(date)) {
      weekends.add(dt);
    }
  }
  System.out.println("There are " + weekends.size() + " distinct weekends."); // 2
}