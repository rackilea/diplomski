String myString = "{abc},{lmn},{xyz}";

System.out.println(myString.split("},").length); // 3

Pattern p = Pattern.compile("},");
String[] result = p.split(myString);
System.out.println(result.length); // 3