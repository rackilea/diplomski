String tested = "Just a regular superbadwording sentece.";
String bad = "%badword%";
bad = bad.replaceAll("%", "\\\\w*");
Pattern p = Pattern.compile(bad);
Matcher m = p.matcher(tested);
while(m.find()) {
    String found = m.group();
    System.out.println(found);
}