public static void lowesttime(String[] names, int[] times) {
    int lowest;
    int lowestIndex = 0;

    lowest = times[0];
    for (int i = 1; i < times.length; i++) {
        if (times[i] < lowest) {
            lowest = times[i];
            lowestIndex = i;
        }
    }
    System.out.println(lowest);
    System.out.println(lowestIndex);

    // to access arrays names[?], times[?}
    // System.out.println(names[lowest] + ": " + times[lowest]);

}