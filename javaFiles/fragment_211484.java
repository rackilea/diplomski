Set<SomeClass> set = new HashSet<SomeClass>();
Set<SomeClass> removalSet = new HashSet<SomeClass>();
fillSet(set);

for (SomeClass currentElement : set) {
    removalSet.addAll(setOfElementsToRemove(currentElement);
}

set.removeAll(removalSet);