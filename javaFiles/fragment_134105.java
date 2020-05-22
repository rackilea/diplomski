public static void swapMinAndMax(Measurable[] objects) {
    int largest = 0, smallest = 0;
    for (int i = 1; i < objects.length; i++) {
        Measurable current = objects[i];
        if (objects[largest].getMeasure() < current.getMeasure()) {
            largest = i;
        }
        if (objects[smallest].getMeasure() > current.getMeasure()) {
            smallest = i;
        }
    }
    // Now swap, we know the indexes.
    Measurable temp = objects[largest];
    objects[largest] = objects[smallest];
    objects[smallest] = temp;
}