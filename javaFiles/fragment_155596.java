public static void main(String[] args) {
    String str = "123-21-1234 this is another text - some text 222-34-2244 another text";
    Pattern p = Pattern.compile("(\\d{3})-(\\d{2})-(\\d{4})");
    Matcher m = p.matcher(str);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {            
        String num = m.group();
        m.appendReplacement(sb, num.replace('-', '/'));
    }
    m.appendTail(sb);
    System.out.println(sb.toString());
}