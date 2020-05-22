boolean matches(String word, String letter1, String letter2, String letter3) throws IllegalArgumentException {

    String[] s = new String[] {letter1, letter2, letter3};

    for (String l : s) {
        if (l.length() != 1)
            throw new IllegalArgumentException("Wrong input, only 1-char strings are allowed!");
        if (l < "a" || l > "z")
            throw new IllegalArgumentException("Wrong input, only lowercase latin letters are allowed!");
    }   

    Pattern regex = Pattern.compile(s[0] + ".*" + s[1] + ".*" + s[2] + ".*");

    // will produce a regex like "a.*b.*c.*"

    return regex.matcher(word).matches();
}