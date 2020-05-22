public int countWord(String chain, String word){
    if("".equal(word)){
        throw new IllegalArgumentException("word is empty string"); // error when word is empty string
    }
    index = 0;
    count = 0;
    while (index != -1){
        int found = chain.indexOf(word, index);
        if(found != -1){
            count++;
            index = found + word.length();
        }
    }
    return count;
}