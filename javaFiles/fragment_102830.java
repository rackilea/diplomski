Scanner in = new Scanner(System.in);
if(firstCard.getFace().equals("Ace")){
    int aceControl=0;
    while(aceControl!=1&&aceControl!=11){
        System.out.print("Type 1 if your Ace is low and 11 if it is high");
        aceControl=in.nextint();
    }
    firstCard.setValue(aceControl);
}
if(secondCard.getFace().equals("Ace")){
    int aceControl=0;
    while(aceControl!=1&&aceControl!=11){
        System.out.print("Type 1 if your Ace is low and 11 if it is high");
        aceControl=in.nextint();
    }
    secondCard.setValue(aceControl);
}