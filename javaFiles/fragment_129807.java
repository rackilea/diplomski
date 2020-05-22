public static void main () {

    // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();

        // The factory for the event
        LogEventFactory factory = new LogEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 262144;

        // Construct the Disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<LogEvent>(factory, bufferSize, executor);

        // Connect the handler
        disruptor.handleEventsWith(new LogEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);

        **for (String name : cache.keySet()) {



            String key = name.toString();
            String value = cache.get(name).toString();

            producer.onData(cache.get(name));
            //Thread.sleep(2000);
            //System.out.println("key:" + key + " " + "//value:" + cache.get(name).getTags());

        }**