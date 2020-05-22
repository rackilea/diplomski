public static class TopNMapper extends Mapper<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {
    private static class MyPair implements Comparable<MyPair> {
        public final int key;
        public final double value;

        MyPair(int key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(MyPair o) {
            return -Double.compare(value, o.value); // i'm not sure about '-'
        }
    }

    private final PriorityQueue<MyPair> topN = new PriorityQueue<MyPair>();

    @Override
    protected void map(IntWritable key, DoubleWritable value, Context context) throws IOException, InterruptedException {
        if (Double.isNaN(value.get())) {
            return; // not a number
        }
        topN.add(new MyPair(key.get(), value.get()));
        if (topN.size() <= 50) { // simple optimization
            return;
        }
        while (topN.size() > 3) { // retain only top 3 elements in queue
            topN.poll();
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        while (topN.size() > 3) {
            topN.poll(); // retain only top 3 elements in queue
        }
        for (MyPair myPair : topN) { // write top 3 elements
            context.write(new IntWritable(myPair.key), new DoubleWritable(myPair.value));
        }
    }
}