String str = "aaaa";
Pattern p1= Pattern.compile("(aa)");
Matcher matcher = p.matcher(str);
int start = -1;
while(matcher.find(start + 1)) {
    start = matcher.start(0);
    System.out.println("Found: " + start);
}