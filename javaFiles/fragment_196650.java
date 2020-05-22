class RegEx {
    public static void main(String[] args) {
        String s = "hello-there";
        String r = "[^a-zA-Z]+";
        String o = s.replaceAll(r, "");
        System.out.println(o); //-> hellothere
    }
}