for(int i=0;i<52;i++){
    int cardType=i/13;
    String type="Heart";
    if(cardType==0)type="Spades";
    else if(cardType==1)type="Clubs";
    else if(cardType==2)type="Diamond";
    cards[i]=new Card(i, cardType);
}