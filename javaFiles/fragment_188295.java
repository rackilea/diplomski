String in = "abcdefghij";
String part1 = "cd";
String part2 = "gh";

int i1 = in.indexOf(part1) + part1.length();  // end of first match
int i2 = in.indexOf(part2, i1);               // start of second match

System.out.println(in.substring(i1, i2));     // "ef"