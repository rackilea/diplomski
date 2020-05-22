public class MyBean {
    private Processor processor;

    @Inject
    public void setProcessor(final Processor processor) {
        this.processor = processor;
    }
}