StringBuilder line = new StringBuilder("this is my start and my end string");
int start = line.indexOf("start");
line.delete(start, start + 5);
int end = line.indexOf("end");
line.delete(end, end + 3);
String result = sb.toString()