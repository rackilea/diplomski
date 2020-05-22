String strDate = "06/04/1992";
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
Date date = null;
try {
    date = dateFormat.parse(strDate);
} catch (ParseException e) {
    e.printStackTrace();
}

String newDateObjectAsString = dateFormat.format(date);

System.out.println(date);
System.out.println(newDateObjectAsString);