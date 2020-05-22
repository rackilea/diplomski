Pattern p = Pattern.compile(".+?\\..+?\\.(\\w)");
Matcher m = p.matcher(str1);

if (m.find()) {
     System.out.println(m.group(1));
}