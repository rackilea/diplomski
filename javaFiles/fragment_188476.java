String content ="RTSP/1.0 200 OK\n" +
   "CSeq: 3\n" +
   "Server: Ants Rtsp Server/1.0\n" +
   "Date: 21 Oct 2016 15:55:30 GMT\n" +
   "Session: 980603187; timeout=60\n" +
   "Transport: RTP/AVP/TCP;unicast;interleaved=0-1;ssrc=F006B800\n";
Pattern pattern = Pattern.compile("Session: ([a-zA-Z0-9$\\-_.+]+)");
Matcher matcher = pattern.matcher(content);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}