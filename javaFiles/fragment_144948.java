for(String subStr : strArr) {
    // New StringBuilder per String
    StringBuilder stringBuilder = new StringBuilder(subStr);

    char first = subStr.charAt(0);

    if ((first=='a') || (first == 'e') || (first == 'i') || (first == 'o') || (first == 'u')){ //starts with a vowel
        stringBuilder.append((char)charRand1); //appends y1 to the end of the string
        stringBuilder.append((char)alphaRand3); //appends x3 to the end of the string
        stringBuilder.append((char)alphaRand4); //appends x4 to the end of the string
        stringBuilder.append(" ");
        encryptedSS = stringBuilder.toString(); //converts stringbuilder back to string
    }
    else{ //starts with a consonant
        stringBuilder.deleteCharAt(0); //deletes the first character
        stringBuilder.append(first); //appends the first character to the end of the word
        stringBuilder.append((char)alphaRand1); //append x1 to the end of the word
        stringBuilder.append((char)alphaRand2); //append x2 to the end of the word*/
        stringBuilder.append(" ");

        encryptedSS = stringBuilder.toString(); //converts string builder back to an array
    }