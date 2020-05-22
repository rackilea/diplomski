public static void testHand(PokerHand d) {
    royalFlush += d.isRoyalFlush() ? 1 : 0;
    straightFlush += d.isStraightFlush() ? 1 : 0;
    fourtOfAKind += d.is4OfAKind() ? 1 : 0; // <-- this appears to be a typo.
    fullHouse += d.isFullHouse() ? 1 : 0;
    flush += d.isFlush() ? 1 : 0;
    straight += d.isStraight() ? 1 : 0;
    threeOfAKind += d.is3OfAKind() ? 1 : 0;
    twoPair += d.is2Pair() ? 1 : 0;
    pair += d.isPair() ? 1 : 0;
    highCard += d.isHighCard() ? 1 : 0;
}