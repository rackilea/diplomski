for(int i=0;i<52;i++){
    Card tempCard = hand1.getCards().remove(hand1.getCards().indexOf(hand1.drawRandomCard()));
    if(i%2 == 1){
        firstPlayersCards.add(tempCard);
    }else{
        secondPlayersCards.add(tempCard);
    }
}