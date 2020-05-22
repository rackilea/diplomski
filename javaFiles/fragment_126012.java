public static boolean charIsVowel(char c) {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

    for(char ch : vowels) {
        if(c == ch) {
            return true;
        }
    }

    return false;
}