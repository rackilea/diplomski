int threshold = 3;
String str = "piid1,piid2,piid3,piid4,piid5";
Pattern p = Pattern.compile("((?:[^,]*,[^,]*|[^,]+){" + (threshold-1) + "})(?:,|$)");
Matcher m  = p.matcher(str);
while (m.find()) {
    System.out.println(m.group(1));
}