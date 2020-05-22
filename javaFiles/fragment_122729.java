public static int[] genRandoms(int total, int numberOfRandoms, int minimumValue) {
    int[] ret = new int[numberOfRandoms];
    Random rnd = new Random();
    int totalLeft = total;
    for (int i = 0; i < numberOfRandoms; i++) {
        final int rollsLeft = numberOfRandoms - i;
        int thisMax = totalLeft - (rollsLeft - 1) * minimumValue;
        int thisMin = Math.max(minimumValue, totalLeft / rollsLeft);
        int range = thisMax - thisMin;
        if (range < 0)
            throw new IllegalArgumentException("Cannot have " + minimumValue + " * " + numberOfRandoms + " < " + total);
        int rndValue = range;
        for (int j = 0; j * j < rollsLeft; j++)
            rndValue = rnd.nextInt(rndValue + 1);
        totalLeft -= ret[i] = rndValue + thisMin;
    }
    Collections.shuffle(Arrays.asList(ret), rnd);
    return ret;
}

public static void main(String... args) throws IOException {
    for (int i = 100; i <= 1000; i += 150)
        System.out.println("genRandoms(" + i + ", 30, 10) = " + Arrays.toString(genRandoms(1000, 30, 10)));
}