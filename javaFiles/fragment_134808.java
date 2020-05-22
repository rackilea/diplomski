String s = "1234 efg(567)";
Matcher m = Pattern.compile("^(?:(\\d+)\\s+(?:(\\S+)\\s)?)?([^(]+\\([^)]*\\))$").matcher(s);
while(m.find()) {
    if(m.group(1) != null)
        System.out.println(m.group(1));
    if(m.group(2) != null)
        System.out.println(m.group(2));
    if(m.group(3) != null)
        System.out.println(m.group(3));
}