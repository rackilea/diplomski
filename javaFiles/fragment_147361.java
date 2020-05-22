String s = "mpla 12.5 mpla 121.22 mpla 1.52 mpla 1 mpla 1000 mpla 1000.12 mpla12.5";
Pattern p = Pattern.compile("[A-Za-z]+|\\s(\\d{1,3}(\\.\\d{1,2})?\\s)?");
Matcher m = p.matcher(s);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    sb.append(m.group());
}
System.out.println(sb.toString());