String dateString = "Wed, 28 Aug 2014 15:47";
SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm");
SimpleDateFormat dateFormatter2 = new SimpleDateFormat("EEE, dd MMM yyyy");
Date date = null;
if(dateString.length() == "EEE, dd MMM yyyy HH:mm".length()) {
    date = dateFormatter.parse(dateString);
} else {
    date = dateFormatter2.parse(dateString);
}
SimpleDateFormat destinationFormatter = new SimpleDateFormat("dd/MM/yyyy");
System.out.println(destinationFormatter.format(date));