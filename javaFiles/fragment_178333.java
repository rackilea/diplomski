String str = "CODE FIRSTTYPE: [DATA OF FIRST TYPE] SECONDTYPE: [DATA OF SECOND TYPE]";
Pattern r = Pattern.compile("\\[([^\\]]*)\\]|(\\S+)");
Matcher matcher = r.matcher(str);
List<String> arr = new ArrayList<String>();
while (matcher.find()) {
    if (matcher.group(1) == null)
       arr.add(matcher.group(2));
    else
        arr.add(matcher.group(1));
}
// PRINT FOR DEMO
String[] simpleArray = new String[arr.size()];
arr.toArray(simpleArray);
for (String s : simpleArray) { System.out.println(s); }