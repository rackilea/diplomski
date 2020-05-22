public void mousePressed() {
         for (int i = 0; i < 6; i++) {
        //first flip cards
        cards[i].flip();

        //then display them
        cards[i].display(this);
    }