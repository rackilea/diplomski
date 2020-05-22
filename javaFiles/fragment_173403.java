public void createSuit(int offset, String name){
    for(int i = 2; i <= 10; i++){
        cardArray[offset + i - 2]=new Card(Integer.toString(i),name,i);
    }
    cardArray[offset + 9]=new Card("Jack",name,10);
    cardArray[offset + 10]=new Card("Queen",name,10);
    cardArray[offset + 11]=new Card("King",name,10);
    cardArray[offset + 12]=new Card("Ace", name,1);
}