while (flush == false) {

    // To simulate the use of one deck, only one of each card can be
    // dealt in a hand.
    while (card1 == card2 || card1 == card3 || card1 == card4 || card1 == card5
            || card2 == card3 || card2 == card4 || card2 == card5 || card3 == card4
            || card3 == card5 || card4 == card5) {

        // Cards 1-13 are the hearts, 14-26 the spades, 27-39 the
        // clubs, and 40-52 the diamonds.
        card1 = r.nextInt(52) + 1;
        card2 = r.nextInt(52) + 1;
        card3 = r.nextInt(52) + 1;
        card4 = r.nextInt(52) + 1;
        card5 = r.nextInt(52) + 1;
    }

    // Calculate the max and min of the cards.
    int max = Math.max(card1, Math.max(card2, Math.max(card3, Math.max(card4, card5))));
    int min = Math.min(card1, Math.min(card2, Math.min(card3, Math.min(card4, card5))));

    // Check if the hand dealt is a royal straight flush by
    // confirming that
    // they span 5 consecutive numbers (this is true if the
    // difference between
    // the max and min is 4 since they are all different), and that
    // they all come
    // from the same suit (1-13, 14-26, 27-39, or 40-52).

    if (max - min == 4) {
        if ((1 <= min) && (13 >= max)) {
            flush = true;
        } else if ((14 <= min) && (26 >= max)) {
            flush = true;
        } else if ((27 <= min) && (39 >= max)) {
            flush = true;
        } else if ((40 <= min) && (52 >= max)) {
            flush = true;
        } else {
            i++;
        }
    } else {
        i++;
    }
    card1 = card2 = card3 = card4 = card5;
}