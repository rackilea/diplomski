String day = dayList.getSelectedItem().toString();
String month = monthList.getSelectedItem().toString();
String year = yearList.getSelectedItem().toString();

if (!day.equals("Day") && !month.equals("Month") && !year.equals("Year")) {
     String dateAsString = day + "/" + month + "/" + year;
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     try {
         Date date = sdf.parse(dateAsString);
     } catch (ParseException e1) {}
}