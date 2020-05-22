private static List<Fruits> getFruits() {
    EnumSet<Fruits> local = EnumSet.of(CURRENT_FRUIT);
    EnumSet<Fruit> otherFruits = EnumSet.complementOf(CURRENT_FRUIT);

    // start by adding and shuffling otherFruits
    List<Fruits> result = new ArrayList<Fruits>(otherFruits)
    Collections.shuffle(result, new Random(System.nanoTime()));

    // now add local
    result.addAll(new ArrayList<Fruits>(local));
    return result;
}