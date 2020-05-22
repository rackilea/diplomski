Pattern p = Pattern.compile(Pattern.quote(part1)
                         + "(.*?)"
                         + Pattern.quote(part2));

Matcher m = p.matcher(in);

if (m.find()) {
    System.out.println(m.group(1));  // "ef"
}