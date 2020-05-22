Iterator<Character> itr=LettersCollected.iterator()
while(itr.hasNext()){
     Character letter=itr.next()
     if(answerWord.charAt(i) == letter){
      itr.remove();
   }
}