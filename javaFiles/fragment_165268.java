public static List<int[]> generateShuffledPairs(int n) {
    ArrayList<int[]> pairs = new ArrayList<int[]>();
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            pairs.add(new int[] { i, j });
        }
    }

    Collections.shuffle(pairs, new Random());
    return pairs;
}

public static void main(String[] args) {
    for (int[] pair : generateShuffledPairs(10)) {
        System.out.println("" + pair[0] + "-" + pair[1]);
    }
}