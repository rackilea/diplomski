String str = "http://google.com";

String rx = "(?i)\\b(http|rtmp|rtsp|mmsh|mms)://[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
while (m.find()) {
   System.out.println(m.group(0));
}