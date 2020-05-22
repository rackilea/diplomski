Set<String> strings = loadStrings();
collectionContains(strings, "pizza");

Collection<Integer> ints = Arrays.toList(1, 2, 3, 4, 5);
collectionContains(ints, 1337);

List<Collection<?>> collections = new ArrayList<>();
collectionContains(collections, ILLEGAL_COLLECTION);