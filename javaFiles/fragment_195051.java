// this will be the current line of the file 
String s = "tree trees asderi 12";

String[] fragments = s.split(" ");

String thirdColumn = fragments[2];
boolean hasI = thirdColumn.contains("i");

String firstColumn = fragments[0];

System.out.println("Fragment: "+thirdColumn+" contains i: "+hasI+" thats why i want the first fragment: "+firstColumn);