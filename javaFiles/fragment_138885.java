public static void main(String[] args) {
    String s = "SUB8&20.000,-&succes&09/12/18SUB12&100.000,-&failed&07/12/18SUB16&40.000,-&succes&09/12/18";
    Pattern p = Pattern.compile("SUB([^,]*),-&succes");
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group(1));
    }
}