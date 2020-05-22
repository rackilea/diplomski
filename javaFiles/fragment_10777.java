private String randomize(String s) {
    String re = "";
    int len = s.length();
    for(int i = 0; i < len - 1; i++) {
        char c = s.charAt(i);
        re += c;
        re += (char) (generator.nextInt('z' - 'a') + 'a');
    }
    re += s.charAt(len - 1);
    return re;
}

private String normalize(String s) {
    String re = "";
    for(int i = 0; i < s.length(); i+=2) {
        re += s.charAt(i);
    }
    return re;
}