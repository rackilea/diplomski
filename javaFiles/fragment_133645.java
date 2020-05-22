static class MyRecord {
    String text;
    int id;
    double d;

    public MyRecord(String text, int id, double d) {
        this.text = text;
        this.id = id;
        this.d = d;
    }

    public int getId() {
        return id;
    }
}

public static void main(String[] args) {
    for (int t = 0; t < 100; t++) {
        long start = System.nanoTime();
        Random rand = new Random();
        Map<Integer, MyRecord> map = IntStream.range(0, 20000)
                .mapToObj(i -> new MyRecord("text-" + i, rand.nextInt(i+1), i))
                .collect(Collectors.groupingBy(MyRecord::getId, 
                        Collectors.reducing(null, (a, b) -> a == null ? b : a)));
        long time = System.nanoTime() - start;
        System.out.printf("Took %.1f ms to generate and collect duplicates%n", time/1e6);
    }
}