Calendar cal = Calendar.getInstance();
cal.set(Calendar.YEAR, 2000);

SimpleDateFormat inFormat = new SimpleDateFormat("dd/MM/yy");
inFormat.set2DigitYearStart(cal.getTime());
SimpleDateFormat outFormat = new SimpleDateFormat("MM/dd/yyyy");
try {
    // Old Date is 10/12/03
    String value = outFormat.format(inFormat.parse("10/12/03"));
    System.out.println(value);
} catch (ParseException e) {
    e.printStackTrace();
}