System.out.println("‘".length()); 
 // displays 1
 System.out.println(new String("‘".getBytes(), "UTF-16").length()); 
 // displays 2
 System.out.println(new String("‘".getBytes(), "ISO-8859-1").length()); 
 // displays 3