//removed (commented)
//StringBuffer tempWord = new StringBuffer(Word);
for(int i = 0; i<Word.length(); i++) {
    //using StringBuilder rather than StringBuffer since you don't need synchronization at all
    StringBuilder tempWord = new StringBuilder(Word);
    tempWord = tempWord.insert(i, addLetter);
    System.out.println(tempWord);
}