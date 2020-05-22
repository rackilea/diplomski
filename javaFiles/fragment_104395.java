private static String translateWord(String s) {
    int firstVowelIndex = firstVowel(s);
    if (firstVowel < 0) { // no Vowel
        return s + "ay";
    } else if (firstVowel == 0) {  // start with Vowel
        return s + "yay";
    } else {
        return s.substring(firstVowelIndex) + s.substring(0, firstVowelIndex) + "ay";
    }
}