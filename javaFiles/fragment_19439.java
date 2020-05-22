String target = "31,5,46,7,86";

Pattern compileFirst = Pattern.compile("(?<number>[0-9]+)(,([0-9])+)*");
Pattern compileFollowing = Pattern.compile(",(?<number>[0-9]+)");

Matcher matcherFirst = compileFirst.matcher(target);
Matcher matcherFollowing = compileFollowing.matcher(target);

System.out.println("matches: " + matcherFirst.matches());
System.out.println("first: " + matcherFirst.group("number"));

int start = 0;
while (matcherFollowing.find(start)) {
    String group = matcherFollowing.group("number");

    System.out.println("following: " + start + " - " + group);
    start = matcherFollowing.end();
}