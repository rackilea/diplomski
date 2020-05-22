public class Job {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<Event> stream = env.fromElements(new Event("a", 1), new Event("b", 2), new Event("a", 2)).assignTimestampsAndWatermarks(new AssignerWithPunctuatedWatermarks<Event>() {
            @Nullable
            @Override
            public Watermark checkAndGetNextWatermark(Event event, long l) {
                return new Watermark(l);
            }

            @Override
            public long extractTimestamp(Event event, long l) {
                return event.getTimestamp();
            }
        });

        DataStream<Tuple2<String, Integer>> count = stream.keyBy(new KeySelector<Event, String>() {
                @Override
                public String getKey(Event event) throws Exception {
                    return event.getSource();
                }
            })
            .timeWindow(Time.minutes(5))
            .fold(Tuple2.of("", 0), new FoldFunction<Event, Tuple2<String, Integer>>() {
                @Override
                public Tuple2<String, Integer> fold(Tuple2<String, Integer> acc, Event o) throws Exception {
                    return Tuple2.of(o.getSource(), acc.f1 + 1);
                }
            });

        count.print();

        env.execute();
    }

    public static class Event {
        private final String source;
        private final long timestamp;

        public Event(String source, long timestamp) {
            this.source = source;
            this.timestamp = timestamp;
        }

        public String getSource() {
            return source;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}