String str = "&lt;accountName&gt;THOMAS M PINCHBECK&lt;/accountName&gt;"+
    "&lt;accountName&gt;Hello world&lt;/accountName&gt;"+
    "&lt;accountName&gt;Quick brown fox&lt;/accountName&gt;";
Pattern p = Pattern.compile("&lt;accountName&gt;([^&]*)&lt;/accountName&gt;");
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group(1));
}