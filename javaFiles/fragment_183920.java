public static void main(String... args) throws Exception {
    String str = "hi im john and my email is <john@hotmail.com> and my number is <0123456789>";
    Pattern p = Pattern.compile("<(.*?)>");
    Matcher m = p.matcher(str);
    while(m.find()) {
        System.out.println(m.group(1));
    }
}