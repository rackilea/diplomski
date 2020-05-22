Set<SomeClass> set = new HashSet<SomeClass>();
fillSet(set);
Iterator<SomeClass> setIterator = set.iterator();
while (setIterator.hasNext()) {
    SomeClass currentElement = setIterator.next();
    if (setOfElementsToRemove(currentElement).size() > 0) {
        setIterator.remove();
    }
}