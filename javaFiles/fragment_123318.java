public static String omitVowels(String input) {
    StringBuilder out = new StringBuilder(input.length());
    String vowels = "aeiouAEIOU";
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (vowels.indexOf(c) >= 0) // is vowel if index not negative
            out.append('_');
        else
            out.append(c);
    }
    return out.toString();
}