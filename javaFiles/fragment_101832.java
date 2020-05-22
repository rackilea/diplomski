static PokerHand evaluateHand(List<Card> hand) {
    for (PokerHand potential : PokerHand.values()) {
        if (potential.matches(hand))
            return potential;
    }

    /* imply there is not a matching hand */
    return null;
}