Pattern p = Pattern.compile("(<http:([^>]+)>)");
Matcher m = p.matcher("<http:fluffy1@cisco.com>,<http:fluffy2@cisco.com>");
while (m.find()) {
    String groupValue = m.group(1); // m.group(2) for email only without http: and <>
    System.out.println(groupValue);
}