Deque<Market> isSuspended = new ArrayDeque<>();
Deque<Market> notSuspended = new ArrayDeque<>();
for (;;) { // loop forever
    data = /*get next batch here*/;
    if (data.isEmpty())
        break;

    // Find unprocessed
    for (Market market : data) {
        if (! market.wasProcessed) {
            if (market.getIsSuspended())
                isSuspended.add(market);
            else
                notSuspended.add(market);
        }
    }

    // Pair up
    while (! notSuspended.isEmpty() && ! isSuspended.isEmpty()) {
        Market market1 = notSuspended.remove();
        Market market2 = isSuspended.remove();
        Pair<Market, Market> marketPair = new Pair<>(market1, market2);
        market1.setWasProcessed(true);
        market2.setWasProcessed(true);
        // use marketPair here
    }
}