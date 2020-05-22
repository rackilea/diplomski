BufferedReader br = ...;
String line;
while (null != (line = br.readLine())) {
    String ip = getIP(line);
    String page = getPage(line);
    int month = getMonth(line);
    // update hashmaps and arrays
}