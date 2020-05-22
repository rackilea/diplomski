//1st possibility: every single whitespace character (space, tab, newline, carriage return, vertical tab) will be treated as a separator
String s="hello; this is cool?\ngreat,   awesome";
String[] array1 = s.split("\\s");
System.out.println("======first case=====");
for(int i=0; i<array1.length; i++)
    System.out.println(array1[i]);

//2nd possibility (groups of consecutive whitespace characters (space, tab, newline, carriage return, vertical tab) will be treated as a single separator
String[] array2 = s.split("\\s+");
System.out.println("=====second case=====");
for(int i=0; i<array2.length; i++)
    System.out.println(array2[i]);
//notice the difference in the output!!!