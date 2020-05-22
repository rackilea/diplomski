final String regex = "update\\s+(\\w+)\\s+|(\\S+\\s*=\\s*\\S+)(?=.*where)|(where.*)";
final String string = "UPDATE TEMP SET COL1 = -1 , COL2 = 'val' Where COL3 > 45\n";

final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    for (int i = 1; i <= matcher.groupCount(); i++) {
        if(matcher.group(i)!=null)
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}