public void actionPerformed(ActionEvent e) {
    if(e.getSource() == draw) {
        int checked = 0;
        for(int i = 0; i < MAXCARDS; i++) {
            if(cards[i].getChecked()) {
                cards[i] = deck.Draw();
                cards[i].setIcon(new ImageIcon
                        ("Cards/" + cards[i].getValue() + 
                        cards[i].getSuit() + ".png"));
                checked++;
            }
        }
    }
    if(e.getSource() instanceof Card) {
        // ...
    }
}