String outputDate = null;
try {
     Date date = inputFormat.parse(inputDate);
     outputDate = outputFormat.format(date);
} catch (ParseException e) {
     e.printStackTrace();
}
System.out.println("Date: " + outputDate);