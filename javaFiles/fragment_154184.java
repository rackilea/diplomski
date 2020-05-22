final String OLD_FORMAT = "yyyy/MM/dd";
final String NEW_FORMAT = "dd/MM/yyyy";

String oldDateString = rst.getString("dob").replaceAll("-","/");//you to need to replace all the all dashes with slashes
String newDateString;

SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
Date d = sdf.parse(oldDateString);
sdf.applyPattern(NEW_FORMAT);
newDateString = sdf.format(d);