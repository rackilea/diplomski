String line = "[{Action=GoTo, Title=0001000a, Page=1 XYZ 7 797 null}, {Action=GoTo, Title=0001000b, Page=3 XYZ 7 797 null}, {Action=GoTo, Title=0001000c, Page=5 XYZ 7 797 null}, {Action=GoTo, Title=0001000d, Page=7 XYZ 7 797 null}]";
ArrayList<String> list = new ArrayList<>();
Pattern pattern = Pattern.compile("Title=([^,]+), Page=([^}]+)}");
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    list.add(matcher.group(1));
    list.add(matcher.group(2));
}
String[] foo = list.toArray(new String[list.size()]);