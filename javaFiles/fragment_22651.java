if(n == -1) {
    s = s.toLowerCase();
    String firstLetter = new String(s.charAt(0));
    s = s.replaceFirst(firstLetter, firstLetter.toUpperCase());
    return s;
}