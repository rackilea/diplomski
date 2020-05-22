String[] exampleDates = {
    "2015-10-10",
    "2015/10/10",
    "2015-10-30 15:30"
};

Parser parser = new Parser();
for (String dateString : exampleDates) {
  List<DateGroup> dates = parser.parse(dateString);
  Date date = dates.get(0).getDates().get(0);
  System.out.println(date);
}