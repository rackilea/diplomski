outerloop:
    for (int i = 0; i < word.length(); i++) {
        for (int j = 0; j < 5; j++) {
            if (word.charAt(i) == vowel[j]) {
                word = word.substring(i) + word.substring(0, i) + "ay";
                break outerloop;
            }
        }
    }