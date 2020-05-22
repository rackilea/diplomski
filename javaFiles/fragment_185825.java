for(int i = 0; i < aLenght - 1; i++) {
    for(int j = 0; j < bLenght - 1; j++) {
        if(aChars[i] == bChars[j] && aChars[i + 1] == bChars[j + 1]) {
            return true;
        }
    }
}