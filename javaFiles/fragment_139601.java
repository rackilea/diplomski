public static final char MIN = 'a';
public static final char MAX = 'f';

private static void count1(Map<Integer, Integer> occurrences, char[] line) {
    for (int symbol : line) {
        Integer amount = 1;
        if (occurrences.containsKey(symbol)) {
            amount += occurrences.get(symbol);
        }
        occurrences.put(symbol, amount);
    }
}

private static void count2(CharCounter counter, char[] line) {
    counter.addCounts(line);
}

public static void main(String[] args) {
    char[] line = new char[1000];
    for (int i = 0; i < line.length; i++) {
        line[i] = (char) ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }

    Map<Integer, Integer> occurrences;
    CharCounter counter;

    // warmup
    occurrences = new HashMap<>();
    counter = new CharCounter(MAX);
    System.out.println("Start warmup ...");
    for (int i = 0; i < 500_000; i++) {
        count1(occurrences, line);
        count2(counter, line);
    }
    System.out.println(occurrences);
    System.out.println(counter.getCounts());
    System.out.println("Warmup done.");


    // original method
    occurrences = new HashMap<>();
    System.out.println("Start timing of original method ...");
    long start = System.nanoTime();
    for (int i = 0; i < 500_000; i++) {
        count1(occurrences, line);
    }
    System.out.println(occurrences);
    long duration1 = System.nanoTime() - start;
    System.out.println("End timing of original method.");
    System.out.println("time: " + duration1);


    // alternative method
    counter = new CharCounter(MAX);
    System.out.println("Start timing of alternative method ...");
    start = System.nanoTime();
    for (int i = 0; i < 500_000; i++) {
        count2(counter, line);
    }
    System.out.println(counter.getCounts());
    long duration2 = System.nanoTime() - start;
    System.out.println("End timing of alternative method.");
    System.out.println("time: " + duration2);

    System.out.println("Speedup: " + (double) duration1 / duration2);
}