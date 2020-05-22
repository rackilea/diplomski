obj = (String)((Map) (obj2)).get("appsflyerKey");
String s1 = (String)((Map) (obj2)).get("af_timestamp");
obj2 = (String)((Map) (obj2)).get("uid");
obj = com.appsflyer.j.a(
    new StringBuilder()
        .append(((String) (obj)).substring(0, 7))
        .append(((String) (obj2)).substring(0, 7))
        .append(s1.substring(s1.length() - 7))
   .toString()
);
a.put("af_v", obj);