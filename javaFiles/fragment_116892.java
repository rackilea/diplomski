String text = "Keep this.\nAnd keep this.\n\nAnd keep this too.\n"
        + "Chomp this chomp:\nAnything beyond here gets chomped.";
Pattern CHOMP= Pattern.compile("^(.*)chomp:(.*)",  Pattern.MULTILINE);
Matcher m = CHOMP.matcher(text);
if (m.find()) {
    System.out.println("  LINE:" + m.group(0));
    System.out.println("BEFORE:" + m.group(1));
    System.out.println(" AFTER:" + m.group(2));
    System.out.println(">>>");
    StringBuffer sb = new StringBuffer();
    m.appendReplacement(sb, "");
    System.out.print(sb);
    System.out.println("<<<");
}