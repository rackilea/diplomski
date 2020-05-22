public static String enhancePassword(String oldPassword) {
    String vowel[] = { "a", "e", "i", "o", "u" };
    String newVowel[] = { "@", "3", "!", "0", "^" };
    for (int i = 0; i < vowel.length; i++) {
        oldPassword = oldPassword.replaceAll(vowel[i], newVowel[i]);
    }
    return oldPassword;
}