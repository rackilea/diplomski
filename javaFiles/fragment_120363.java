public class CustomAppender extends AbstractAppender {

    private List<String> list = new ArrayList<>();

    public CustomAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    public CustomAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {
        byte[] data = getLayout().toByteArray(event);
        list.add(new String(data).trim()); // optional trim
    }

    @Override
    public void stop() {
        // Write to the database
        System.out.println(list);
    }

}