String s = "[Sometext]MoreText[SomeOtherText] I am hoping to get [SomeText], MoreText, [SomeOtherText]";
Pattern p = Pattern.compile("\\[(?:[^\\]]*)\\]|([a-zA-Z]+(?:\\s+[a-zA-Z]+)*)");
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(m.group());
}