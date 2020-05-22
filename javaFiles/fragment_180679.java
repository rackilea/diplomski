String s = // your input string
Pattern p = Pattern.compile(".*?\\{(.*)\\}.*");
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group(1));
}