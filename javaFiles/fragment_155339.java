Random random = new Random();

for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
    for (int innerIndex = 0; innerIndex < matrix[outerIndex].length; innerIndex++) {
        if (random.nextDouble() < 0.5) {
            matrix[outerIndex][innerIndex] = 1;
        } else {
            matrix[outerIndex][innerIndex] = 0;
        }
    }
}