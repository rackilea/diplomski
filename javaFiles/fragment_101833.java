PokerHand evaluated = null;
for (PokerHand potential : PokerHand.values()) {
    if (potential.matches(sortedHand)) {
        evaluated = potential;
        break;
    }
}

if (evaluated != null) {
    /* it's a recognized hand */
}