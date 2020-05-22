public class AppendableFilteringResponseOutputProvider extends FilteringResponseOutputProvider {

    private final FilteringAppendableWrapper appendable;

    private OutputStream outputStream = new ByteArrayOutputStream();

    public AppendableFilteringResponseOutputProvider(HttpServletResponse aResponse) {
        super(aResponse);

        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        appendable = Components.newInstance(FilteringAppendableWrapper.class);
        appendable.setWrappedAppendable(writer);
    }

    @Override
    public Appendable getAppendable() throws IOException {
        return appendable;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        ((Writer) appendable.getWrappedAppendable()).flush();

        return outputStream;
    }

    @Override
    public void setWriteEnabled(boolean writeEnabled) {
        super.setWriteEnabled(writeEnabled);
        appendable.setWriteEnabled(writeEnabled);
    }
}