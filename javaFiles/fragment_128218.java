static void transferCards (Hand from, Hand to) {
    for (Card card : from.cards) {
        to.addSingleCard(card);
    }
    from.cards.clear();
}