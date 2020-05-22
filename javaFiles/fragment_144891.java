final String ps = "(?i)(\\d+)(?:(?:(?:\\s*)(,|and|through)(?:\\s*))|.*$)";
final Pattern p = Pattern.compile(ps);
for (String s : new String[] {
        "A list of items 1, 2 and 5 containing blah blah blah.",
        "According to items 2 THROUGH 11 there will be blah blah."})
{
    System.out.println("***** TEST STRING *****\n" + s + "\n");
    final Matcher m = p.matcher(s);
    int cnt = 0;
    while (m.find()) {
        System.out.println(++cnt + ": G1: " + m.group(1) + " G2: "
                + m.group(2));
    }
    System.out.println("");
}