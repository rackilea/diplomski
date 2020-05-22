String text = "dstdomain=\"myftp.cpm\" sent_bytes=162 recv_bytes=45 message=\"An FTP download of File resume.doc of size 550k from server ftp.myftp.com could not be completed as file was infected with virus codevirus\"";
String patternText = "\\w+=([^ \"]+|\"[^\"]*\")";
Matcher matcher = Pattern.compile(patternText).matcher(text);
List<String> matches = new ArrayList<String>();
while (matcher.find()) {
    matches.add(matcher.group());
}