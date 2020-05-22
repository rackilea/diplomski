String input = "2012 AL REG TEXT 300535(NS)";
String regex = "^(?:(\\d{4})\\s+)?((?:\\S+)\\s+(?:.+?))\\s+((?:\\S+)(?:\\(.*?\\)))$";
Matcher m = Pattern.compile(regex).matcher(input);
if (m.matches()) {
    for (int i = 1; i <= m.groupCount(); i++) {
        System.out.format("Group %d: '%s'%n", i, m.group(i));
    }
}