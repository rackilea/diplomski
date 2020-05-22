@Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == shuffle) {
    cardA = 1 + (int)(Math.random() * 54);
    while(cardB == cardA){
        cardB = 1 + (int)(Math.random() * 54);
        }
    while (cardC == cardB || cardC == cardB){
        cardC = 1 + (int)(Math.random() * 54);
    }

    firstCard = new ImageIcon("card/" + Integer.toString(cardA) + ".png");
    secondCard = new ImageIcon("card/" + Integer.toString(cardB) + ".png");
    thirdCard = new ImageIcon("card/" + Integer.toString(cardC) + ".png");
    DisplayCards()
}