private static final int PARTITIONS_COUNT = 12;

List<Set<Type>> theSets = new ArrayList<Set<Type>>(PARTITIONS_COUNT);
for (int i = 0; i < PARTITIONS_COUNT; i++) {
    theSets.add(new HashSet<Type>());
}

int index = 0;
for (Type object : originalSet) {
    theSets.get(index++ % PARTITIONS_COUNT).add(object);
}