String emailAdress = "yourname@yourdomin.com";
Pattern emailAddress = Pattern.compile("(.*)(@)(.*)");
Matcher matchEmailAddress = emailAddress.matcher(emailAdress);

matchEmailAddress.find(); //find the next substring matching your pattern
String secondPartOfEmail = matchEmailAddress.group(3);