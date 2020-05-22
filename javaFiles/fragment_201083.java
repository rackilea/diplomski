enum HandType {
    ROYALFLUSH, STRAIGHTFLUSH, FOUROFAKIND, FULLHOUSE, FLUSH,
    STRAIGHT, THREEOFAKIND, TWOPAIR, PAIR, HIGHCARD;

    static HandType fromHand(PokerHand d) {
        if (d.isRoyalFlush()) {
            return ROYALFLUSH;
        } else if (d.isStraightFlush()) {
            return STRAIGHTFLUSH;
        } else if (d.is4OfAKind()) {
            return FOUROFAKIND;
        } else if (d.isFullHouse()) {
            return FULLHOUSE;
        } else if (d.isFlush()) {
            return FLUSH;
        } else if (d.isStraight()) {
            return STRAIGHT;
        } else if (d.is3OfAKind()) {
            return THREEOFAKIND;
        } else if (d.is2Pair()) {
            return TWOPAIR;
        } else if (d.isPair()) {
            return PAIR;
        } else {
            return HIGHCARD;
        }
    }
}