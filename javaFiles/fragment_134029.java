//divide the line into strings with "=".
StringTokenizer tz = new StringTokenizer(line, "=");
//get the first part, "library". 
String token = tz.nextToken(); 
//get the second part, "/usr/local/lib/libbit4ipki.so name"
token = tz.nextToken();
....