void addToRanksInOrderWithUpDown(Rank r) {
    r.setUp(r);
    if (ranksInOrder.isEmpty()) {
        r.setDown(r);
    } else {
        Rank last = ranksInOrder.get(ranksInOrder.size() - 1);
        r.setDown(last);
        last.setUp(r);
    }
    ranksInOrder.add(r);
}