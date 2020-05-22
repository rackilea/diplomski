int index = 0;
for(; index<userWord.length(); index++) {
    if(charIsVowel(userWord.charAt(index))) {
        break;
    }
}

String translation = userWord.substring(index) + "-" + userWord.substring(0, index);