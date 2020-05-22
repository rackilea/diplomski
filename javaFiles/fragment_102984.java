public static void main(String... ignored) {
    int[] cards = new int[52];
    for (int i = 0; i < cards.length; i++) cards[i] = i;

    long start = System.currentTimeMillis();
    int runs = 1000000;
    for (int i = 0; i < runs; i++) {
        shuffleN(cards, 5);
        int card1 = cards[0], card2 = cards[1], card3 = cards[2], card4 = cards[3], card5 = cards[4];
    }
    long time = System.currentTimeMillis() - start;
    System.out.printf("Took %.3f seconds to shuffle %,d times%n", time / 1e3, runs);
}

private static final Random RND = new Random();

public static void shuffleN(int[] numbers, int count) {
    for (int i = 0; i < count; i++) {
        int r = RND.nextInt(numbers.length - i) + i;
        if (i == r) continue;
        int tmp = numbers[i];
        numbers[i] = numbers[r];
        numbers[r] = tmp;
    }
}