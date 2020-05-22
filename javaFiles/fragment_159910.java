public class StreamOnOpenTest {
    LinkedHashMap<String, Long> times = new LinkedHashMap<String, Long>();

    public static void main(String[] args) {
        StreamOnOpenTest test = new StreamOnOpenTest();

        test.addTime("SkipMethod", test.time(IntStream.range(0, 1000000).mapToObj(e -> "" + e), (stream) -> {
            stream
                .skip(StreamOnOpenTest.labelData())
                .map(e -> "Number " + e)
                .forEach(System.out::println);              
        }));


        test.addTime("PeekMethod", test.time(IntStream.range(0, 1000000).mapToObj(e -> "" + e), (stream) -> {
            OneTimePrinter printer = new OneTimePrinter();
            stream
                .peek((e) -> printer.print("TEST OUTPUT:\n------------"))
                .map(e -> "Number " + e)
                .forEach(System.out::println);          
        }));

        test.addTime("CollectMethod", test.time(IntStream.range(0, 1000000).mapToObj(e -> "" + e), (stream) -> {
            stream
                .collect(StreamOpenCollector.onOpen("TEST OUTPUT:\n------------", System.out::println))
                .map(e -> "Number " + e)
                .forEach(System.out::println);      
        }));    

        test.printTimes();
    }

    private void addTime(String key, long value){
        times.put(key, value);
    }

    private void printTimes() {
        System.out.println("------------\n------------\n");
        times.forEach((key, value) -> System.out.println("For " + key + ", time was " + value + " milliseconds"));
    }

    private long time(Stream<String> stream, Consumer<Stream<String>> consumer){
        long startTime = System.currentTimeMillis();
        consumer.accept(stream);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static int labelData(){
        System.out.println("TEST OUTPUT:");
        System.out.println("------------");
        return 0;
    }
}