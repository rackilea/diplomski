Array<Sprite> drawnCards = new Array<Sprite>();
int randomCardNr = (int) Math.random() * 52;

for (int i = 0; i < amountOfCardsToBeDrawn; i++) {
    if (!drawnCards.contains(yourCardArray.get(randomCardNr)) { // Check if it hasn't been drawn before

        drawCard(yourCardArray.get(randomCardNr)); // This is your method to draw a card
        drawnCards.add(yourCardArray.get(randomCardNr)); // Add to drawnCards array
    }
}