public class Example {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        env.addSource(...)
           .filter(new Limiter())
           .print();

        env.execute();
    }

    public static class Limiter implements FilterFunction<Event> {
        private transient int count = 0;

        @Override
        public boolean filter(Event e) throws Exception {
            if (++count <= 10) {
                return true;
            } else {
                return false;
            }
        }
    }
}