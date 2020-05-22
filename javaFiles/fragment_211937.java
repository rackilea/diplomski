private int arrayCounter = 0;
public void insertWord(String word) {
    if(word == null){
        return;
    }
    boolean isWordPresent = false;
    // SCAN the whole array and see if the word is present in it else after
    // the loop ends then add new word 
    // Also you just need to check till 'arrayCounter' as it will always be equal to number of elements in the array
    for (int i = 0; i < arrayCounter; i++) {
        System.out.println(i);
        // equalsIgnoreCase in class java.lang.String returns null if
        // argument passed is Null, so extra check for arrayWords[i] ! =
        // null is not required
        if (word.equalsIgnoreCase(arrayWords[i])) {
            arrayWords[i].addCounter();
            isWordPresent = true;
            break;
        }
    }
    // in case word is not found above then add it as a new word
    if (!isWordPresent) {
        System.out.println("Adding " + word + " to Array");
        arrayWords[arrayCounter++] = new Concordance(word);
    }
}