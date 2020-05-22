private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
public static String translate(String word) {
    int start = 0; // start index of word
    int firstVowel = 0;
    int end = word.length(); // end index of word
    for(int i = 0; i < end; i++) { // loop over length of word
        char c = Character.toLowerCase(word.charAt(i)); // char of word at i, lower cased
        if(Arrays.asList(vowels).contains(c)) { // convert vowels to a list so we can use List.contains() convenience method.
            firstVowel = i;
            break; // stop looping
        }
    }
    if(start != firstVowel) { // if start is not equal to firstVowel, we caught a vowel.
        String startString = word.substring(firstVowel, end);
        String endString = word.substring(start, firstVowel) + "ay";
        return startString+endString;
    }
    return word; //couldn't find a vowel, return original
}