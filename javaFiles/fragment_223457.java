...
String dateString = ...
Date1 date1 = new Date1(dateString);
if (format){
  format = date1.usFormat();
} else {
  format = date1.euFormat();
}