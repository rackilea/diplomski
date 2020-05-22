Pattern p = Pattern.compile("http://.+/(.+?)/.+/.+\\?mno=(.+?)&");
    String s = "http://localhost:8080/IndiaRoute/servlet/SendSMPPClient?mno=919820673883&msg=xxx&sid=xxxx+&mt=0";
    java.util.regex.Matcher m = p.matcher(s);
    if(m.find())
    {
        System.out.println(m.group(1));
        System.out.println(m.group(2));
    }