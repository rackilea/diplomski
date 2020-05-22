public static int howManyWithOverlap(String sentence, String phrase){
    int length = sentence.length();
    int phraseLength = phrase.length();
    int count = 0;
    //Check each phrase of consecutive letters to see if it matches.

    for(int i = 0; i < length - phraseLength + 1; i++){
        if(sentence.substring(i, i + phraseLength).equals(phrase)){
            count++;
        }
    }

    //count is the number of instances in the sentence.
    return count;
}