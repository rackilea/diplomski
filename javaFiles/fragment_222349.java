String data = ""
    + ":32B:xxx,\n"
    + ":59:yyy\n"
    + "something\n"
    + ":70:ACK1\n"
    + "ACK2\n"
    + ":21:something\n"
    + ":71A:something\n"
    + ":23E:something\n"
    + "value\n"
    + ":70:ACK2\n"
    + "ACK3\n"
    + ":71A:something\n";
Pattern pattern = Pattern.compile(":70:(.*?)\\s*:", Pattern.DOTALL);
Matcher matcher = pattern.matcher(data);
while (matcher.find())
    System.out.println("found="+ matcher.group(1));