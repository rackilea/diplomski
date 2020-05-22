//02/29/2016 is the next leap year, other are invalid dates
String[] stringDate = {"04/31/2015", "02/29/2016", "06/40/2015"};
SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
dateFormat.setLenient(false);

for (String str: stringDate) {
    try {
        if(dateFormat.parse(str, new ParsePosition(0)) != null) {
            System.out.println(str + ": valid");
        } else {
            System.out.println(str + ": Invalid date");
        }
    } catch (Exception e) {
      e.printStackTrace();
    }
}