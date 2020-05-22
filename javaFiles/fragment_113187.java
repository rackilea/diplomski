List<Integer> indicesToBeRemoved = new ArrayList<>();
for (int index : indices) { // indices in the sorted list
    indicesToBeRemoved.add(currentListFiltered.getSourceIndex(
        currentListSorted.getSourceIndex(index)));
}
// sort with largest index first, as removing an item with
// a given index will not change the indices of items with small indices:
indicesToBeRemoved.sort(Comparator.reverseOrder()); 
for (Integer index : indicesToBeRemoved) {
    // be careful to explicitly unbox the Integer here, 
    // to avoid collision between remove(Object) and remove(int):
    items.remove(index.intValue());
}