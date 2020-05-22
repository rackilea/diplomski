String s = "PING www.google.com (173.194.70.106) 56(84) bytes of data.";
Pattern p = Pattern.compile("\\(([0-9]{1,3}\\.){3}[0-9]{1,3}\\)");
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group(0));
}