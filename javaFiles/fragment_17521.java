// convert the users guess to a char array
char [] chars = word.toCharArray();

for(char c : chars){
    int charIndex = baseWord.indexOf(c);

    if(charIndex != -1){
        char[] baseWordChars = baseWord.toCharArray();
        baseWordChars[charIndex] = '#';  // char wiped
        baseWord = new String(baseWordChars);
        continue;
    } else {
        System.out.println("The letter " + c + " is not in " + baseWord);
        return 0;
    }
}