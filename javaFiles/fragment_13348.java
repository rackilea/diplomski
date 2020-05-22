void dumpString(String s) {
    for (int i = 0; i < s.length(); ++i) {
        System.out.printf("%04x ", 0xFFFF & (int)s.charAt(i));
    }
    System.out.println(s);
}