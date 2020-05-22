//within MyFile constructor or setter for Words
while (//there's another word to add) {
   Word newWord = new Word(//read word from file);
   words.add(newWord);
   newWord.setMyFile(this);
}