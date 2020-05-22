Pattern p = Pattern.compile("<img src=\"([^\"]*)\" (alt=\"[^\"]*\")>");
Matcher m = 
    p.matcher("<img src=\"http://yahoo.com/img1.jpg\" alt=\"\"> " + 
    "<img src=\"http://yahoo.com/img2.jpg\" alt=\"\">");

while (m.find()) {
    System.out.println(m.group(1) + "  " + m.group(2));
}