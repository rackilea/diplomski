String str = "D[1]+D[0]";
Pattern p = Pattern.compile("[+-/*]");
Matcher m = p.matcher(str);
if (m.find()) {
    System.out.println("Found: " + m.group());
}