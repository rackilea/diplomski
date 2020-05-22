public class SourceFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        //Source class can return null so handle it.
        String cn = String.valueOf(record.getSourceClassName());
        return !cn.startsWith("foo.bar.Child1")
                && !cn.startsWith("foo.bar.Child2")
                && !cn.startsWith("foo.bar.Child3");
    }
}