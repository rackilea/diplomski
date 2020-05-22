for (int i = 0; i < s.length(); ) {
    int cp = s.codePointAt(i);
    System.out.printf(" %x", cp);
    i += Character.charCount(cp);
}
System.out.println();