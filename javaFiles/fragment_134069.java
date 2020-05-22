public static void main(String args[]) {
    String s = "a+2 b+3 c+33 d+88 ";
    Pattern p = Pattern.compile("c\\+(\\d+)");
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.println("Data: " + m.group(1));
    } else {
        System.out.println("Input data doesn't match the regex");
    }
}