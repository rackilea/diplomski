public static String translate(String word) {
    char a = 'a';
    char e = 'e';
    char i = 'i';
    char o = 'o';
    char u = 'u';

    int start = 0;
    int firstVowel = 0;
    int end = word.length();
    for(int i = 0; i < end; i++) {
        char c = Character.toLowerCase(word.charAt(i));
        if(c == a || c == e || c == i || c == o || c == u) {
            firstVowel = i;
            break;
        }
    }
    if(start != firstVowel) {
        String startString = word.subString(firstVowel, end);
        String endString = word.subString(start, firstVowel) + "ay";
        return startString+endString;
    }
    return word;
}