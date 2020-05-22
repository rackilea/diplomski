public void createSpades(){
    int l = 2;
    for(int i = 39; i < 48; i++){
        cardArray[i]=new Card(Integer.toString(l),"Diamonds",l);
        l++;
    }
    cardArray[48]=new Card("Jack","Diamonds",10);
    cardArray[49]=new Card("Queen","Diamonds",10);
    cardArray[50]=new Card("King","Diamonds",10);
    cardArray[51]=new Card("Ace","Spades",1);
}