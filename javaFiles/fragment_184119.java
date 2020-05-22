List<Market> isSuspended = new ArrayList<>();
List<Market> notSuspended = new ArrayList<>();
for (Market market : data) {
    if (! market.wasProcessed) {
        if (market.getIsSuspended())
            isSuspended.add(market);
        else
            notSuspended.add(market);
    }
}
Iterator iter1 = notSuspended.iterator();
Iterator iter2 = isSuspended.iterator();
while (iter.hasNext() && iter2.hasNext()) {
    Market market1 = iter1.next();
    Market market2 = iter2.next();
    Pair<Market, Market> marketPair = new Pair<>(market1, market2);
    market1.setWasProcessed(true);
    market2.setWasProcessed(true);
    // use marketPair here
}