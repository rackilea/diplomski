private static int[] getIntArray() {
    int[] rand;
    if (MAX_SIZE - MIN_SIZE > 0) {
        rand = new int[new Random().nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE + 1];
    } else {
        rand = new int[MIN_SIZE];
    }
    for (int i = 0; i < rand.length; i++) {
        rand[i] = new Random().nextInt(rand.length * 2);
    }
    return rand;
}