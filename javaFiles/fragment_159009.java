@Component
class EventProcessorRunner implements CommandLineRunner {
    private final EventProcessor processor; 

    EventProcessorRunner(final EventProcessor processor) {
       this.processor = processor;
    }

    @Override
    public void run(final String... args) throws Exception {
        processor.startProcess();
    }
}