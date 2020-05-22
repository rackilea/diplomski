String str1 = "12.1.12.1 9000 127.0.0.1 - frank [10/Oct/2000:13:55:36"
            + " -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
            + "\"http://www.example.com/start.html\" \"Mozilla/4.08 "
            + "[en] (Win98; I ;Nav)\"";

String str2 = "12.1.12.1 9000 192.145.1.23 - frank [10/Oct/2000:13:55"
            + ":36 -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
            + "\"http://www.example.com/start.html\" \"Mozilla/4.08 "
            + "[en] (Win98; I ;Nav)\"";

Pattern p = Pattern.compile("\\S+\\s+\\S+\\s+(\\S+).*");

Matcher m = p.matcher(str1);
if (m.matches())
    System.out.println(m.group(1));

m = p.matcher(str2);
if (m.matches())
    System.out.println(m.group(1));