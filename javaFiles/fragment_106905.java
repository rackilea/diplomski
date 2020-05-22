String[] words = str.split(" ");
for (String word : words) {
    int firstVowelIndex = -1;
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (checkIsVowel(ch)) {
            // if vowel index is found again and there exists at least one character between the two vowels
            if (firstVowelIndex != -1 && i - firstVowelIndex != 0) {
                System.out.println(word.substring(firstVowelIndex + 1, i));
            }
            // vowel index is assigned
            firstVowelIndex = i;
        }
    }
}