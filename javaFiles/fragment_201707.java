String input = "40.2%2522%26url%3Dhttp%253A%252F%252Fr1";
String output1 = URLDecoder.decode(input, "UTF-8");
String output2 = URLDecoder.decode(output1, "UTF-8");
System.out.println(input);
System.out.println(output1);
System.out.println(output2);