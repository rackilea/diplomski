static int[][] copyState(int[][] toCopy) {
    int[][] copy = new int[toCopy.length][];
    for(int i = 0; i < copy.length; i++) {

        // or   = Arrays.copyOf(toCopy[i], toCopy[i].length);
        copy[i] = toCopy[i].clone();
    }

    return copy;
}