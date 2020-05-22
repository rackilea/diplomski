public static void main (String[] args) throws Exception {
    int cp = 0x10400;
    String text = "test \uD801\uDC00";
    System.out.println("cp:    " + cp);
    System.out.println("found: " + text.codePointAt(5));
    System.out.println("len:   " + text.length());
}