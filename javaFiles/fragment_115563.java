SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
SimpleDateFormat myFormat = new SimpleDateFormat("MMMM dd, yyyy");

try {    
    String reformattedStr = myFormat.format(fromUser.parse(inputString));
} catch (ParseException e) {
    e.printStackTrace();
}