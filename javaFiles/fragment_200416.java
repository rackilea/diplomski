String str = "\"exArg1\" \"exArg2\" \"exArg3 with space\" exArg4 \"exArg5\"";
Pattern ptrn = Pattern.compile("\"([^\"]*)\"|\\S+"); 
// Or "\"([^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)\"|\\S+" to support escaped quotes
Matcher matcher = ptrn.matcher(str);
List<String> result = new ArrayList<>();
while (matcher.find()) {
    if (matcher.group(1) == null) {
        result.add(matcher.group(0));
    } else {
        result.add(matcher.group(1));
    }
}
System.out.println(result); // => [exArg1, exArg2, exArg3 with space, exArg4, exArg5]