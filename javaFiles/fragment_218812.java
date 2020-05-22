String text = "###Heading 3";
Pattern p = Pattern.compile("(#+)(.*)");
Matcher m = p.matcher(text);
StringBuffer out = new StringBuffer();

while(m.find()) {
    int level = m.group(1).length();
    String title = m.group(2);

    m.appendReplacement(out, String.format("<h%s>%s</h%s>", level, title, level));
}

m.appendTail(out);

System.out.println(out.toString());