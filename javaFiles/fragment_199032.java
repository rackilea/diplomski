public static void main(String[] args) throws IOException {
    Random rand = new Random();

    int samples = 100;
    try (DataOutputStream out = new DataOutputStream(new FileOutputStream("test"))) {
        out.writeInt(samples);
        for (int i = 0; i < samples; i++)
            out.writeInt(rand.nextInt(100));
    }

    int[] sort;
    try (DataInputStream in = new DataInputStream(new FileInputStream("test"))) {
        int len = in.readInt();
        sort = new int[len];
        for (int i = 0; i < len; i++)
            sort[i] = in.readInt();
    }

    IntSummaryStatistics stats = IntStream.of(sort).summaryStatistics();
    System.out.println("The largest number in the file is: " + stats.getMax());
    System.out.println("The smallest number in the file is: " + stats.getMin());
    System.out.println("The average number in the file is: " + stats.getAverage());
}