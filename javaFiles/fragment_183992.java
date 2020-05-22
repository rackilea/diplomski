static String content = "a {non} b {1} c {1}";
static String inline = "\\{[0-9]\\}";

public static void getMatchIndices()
{
    Pattern pattern = Pattern.compile(inline);
    Matcher matcher = pattern.matcher(content);

    int pos = 0;
    while (matcher.find(pos)) {
        int found = matcher.start();
        System.out.println(found);
        pos = found +1;
    }
}