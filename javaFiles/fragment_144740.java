public static void reorder(Animal[] animals) {
    Arrays.sort(animals);
    for (int i = 0, j = animals.length - 1; i < j; ++i, --j) {
        Animal tmp = animals[i];
        animals[i] = animals[j];
        animals[j] = tmp;
    }
}