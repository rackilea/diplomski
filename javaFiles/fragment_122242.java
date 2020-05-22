double value = 2.34;
String pattern = "#.####";
DecimalFormat myFormatter = new DecimalFormat(pattern);
String output = myFormatter.format(value);

System.out.println(value + " " + pattern + " " + output);  // displays  2.34 #.#### 2.34