List<Integer> indexes = new ArrayList<Integer>();

for (int i = 0; i < 1000; i++){
    if (sWorld[i].length > 4) {
         //add i to a list (not an array yet)
         indexes.add(i);
    }
    ...
}
// then sort the list
// not necessary, as indexes are inserted in the right order, but if you must...
// Collections.sort(indexes);

// and, if you need an array instead of a list
Integer[] indexesArray = indexes.toArray(new Integer[indexes.size()]);