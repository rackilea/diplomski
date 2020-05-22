String s = "+24&#160;-2";

// The correct delimiter begins with an '&'
String[] result = s.split("&#160;");

// Print the result
System.out.println(Arrays.toString(result));