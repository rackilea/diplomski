String line = in.nextLine();
Matcher matcher = Pattern.compile(REQUEST_FORMAT).matcher(line);
String request = null;
if(matcher.find()) {
    //request = line.substring(matcher.start(),matcher.end());
    request = matcher.group();//is similar to the commented line above
}