byte[] fileContent = new byte[] {'A', 0x03, 'B'};
String fileContentStr = new String (fileContent);
System.out.println (fileContentStr.contains ("^C")); // false
System.out.println (fileContentStr.contains (String.valueOf ((char) 0x03))); // true
System.out.println (fileContentStr.contains ("\u0003")); // true, thanks to @Thomas Fritsch for the precision

String[] split = fileContentStr.split ("\u0003");
System.out.println (split.length); // 2
System.out.println (split[0]); // A
System.out.println (split[1]); // B