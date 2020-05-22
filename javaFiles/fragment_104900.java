public static void main(String... args) throws IOException {
    timeObjectGraph("First run", 1);
    timeObjectGraph("Second run", 2);
    timeObjectGraph("Next thousand", 1000);
    for (int i = 0; i < 5; i++)
        timeObjectGraph("Next ten thousand", 10000);
}

static int dontOptimiseAway = 0;

public static void timeObjectGraph(String desc, int runs) throws IOException {
    long start = System.nanoTime();
    for (int i = 0; i < runs; i++) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(Calendar.getInstance());
        oos.close();
        dontOptimiseAway = out.toByteArray().length;
    }
    long time = System.nanoTime() - start;
    System.out.printf("%s took an avg time of %,d ns%n", desc, time / runs);
}