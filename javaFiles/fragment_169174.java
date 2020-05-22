Pattern pattern = Pattern.compile("\\.A\\s(\\d+)"); // grouping number
Matcher matcher = pattern.matcher(".A 1 .A 2 .A 3 .A 4 *text* .A5"); // full input string
while (matcher.find()) {
    int n = Integer.valueOf(matcher.group(1)); // getting captured number - group #1
    System.out.println(n);
}