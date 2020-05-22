public static int[] converter(char[] word, char[] characters){
    int[] result = new int[word.length];
    int characterIndex = 0;
    int wordCharacterIndex = 0;
    while(wordCharacterIndex < word.length){
        if(characters[characterIndex] == Character.toUpperCase(word[wordCharacterIndex])){
            result[wordCharacterIndex] = characterIndex + 1;
            wordCharacterIndex++;
            characterIndex = 0;
        } else {
            characterIndex++;
        }
    }
    return result;
}