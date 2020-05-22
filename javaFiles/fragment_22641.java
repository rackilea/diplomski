Pattern p = Pattern.compile("google\\.com$");//I want to know the right format

String input2 = "mail.google.com.co.uk";

Matcher m2 = p.matcher(input2);


boolean found2 = m2.find();
System.out.println(found2);