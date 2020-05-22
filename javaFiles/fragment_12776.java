Iterator<Thing> iter = set.iterator();
Thing previous = iter.hasNext() ? iter.next() : null;
while (iter.hasNext()) {
    final Thing current = iter.next();
    operateOnAdjacentPair(previous, current);
    previous = current;
}