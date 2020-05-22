public static boolean matrixEqual(int[][] a, int[][] b) {
    Map<Integer[], Integer> m = new HashMap<Integer[], Integer>();
    int sizeA = a.length;
    // maybe compare sizeA and sizeB here
    for (int i = 0; i < sizeA; i++) {
        // int[] temp = sorted a[i];
        // if (temp not a key in m) m.put(temp, 1);
        // else m.put(temp, previousvalue + 1);
    }
    int sizeB = b.length;
    for (int i = 0; i < sizeB; i++) {
        // int[] temp = sorted b[i];
        // if (temp not a key in m) return false;
        // else if (m.get(temp) == 0) return false;
        // else m.put(temp, previousvalue - 1);
    }
    return true;
}