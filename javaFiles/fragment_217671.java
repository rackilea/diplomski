Pattern p = Pattern.compile("\\bSap\\b");

String a ="Hello my name is Sap";
Matcher m1 = p.matcher(a);
System.out.println( m1.find());// return true

String b = "HellomynameisSap";
Matcher m2=p.matcher(b);
System.out.println( m2.find());//return false

String c = "Hello Sap my name";
Matcher m3=p.matcher(c);
System.out.println( m3.find());//return true

String d = "Sap";
Matcher m4=p.matcher(d);
System.out.println( m4.find());//return true