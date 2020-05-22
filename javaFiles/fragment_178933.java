// this iterates over existing cards
Iterator<Card> iter = hand.iterator();

// but there are no cards yet
while (iter.hasNext() /* this will never return true */ ) {
    // so this is never executed
    hand.add(gr.pickRandomCard());
}