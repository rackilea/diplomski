String[] onScreen() { 

    String[] cardsToPlay = new String[9];

    for (int i = 0; i < cardsToPlay.length; i++) {

        int randomCard = int(random(kaarten.length));
        cardsToPlay[i] = kaarten[randomCard];

        String lastCard = kaarten[kaarten.length-1];
        kaarten[kaarten.length-1] = kaarten[randomCard];
        kaarten[randomCard] = lastCard;

        kaarten = shorten(kaarten);
    }
    return cardsToPlay ;
}