public static void reorder(Animal[] animals) {
    int first = 0;
    int last = animals.length - 1;
    while (first < last) {
        /*
         * The unsorted elements are in positions first..last (inclusive).
         * Everything before first is the higher animal; everything after
         * last is the lower animal.
         */
        while (animals[first].ordinal() == 1 && first < last) {
            ++first;
        }
        while (animals[last].ordinal() == 0 && first < last) {
            --last;
        }
        if (first < last) {
            /*
             * At this point, the sort conditions still hold and also we know
             * that the animals at first and last are both out of order
             */
            Animal temp = animals[first];
            animals[first] = animals[last];
            animals[last] = temp;
            ++first;
            --last;
        }
    }
}