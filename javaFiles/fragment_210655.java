// assumes a java.util.Random called random
boolean[] randomBools(int len) {
    boolean[] arr = new boolean[len];
    for(int i = 0; i < len; i++) {
        arr[i] = random.nextBoolean();
    }
    return arr;
}