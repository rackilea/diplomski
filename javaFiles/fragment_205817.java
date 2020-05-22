public class MyClass {
    private static final String FILENAME_DATE_PATTERN = "yyMMdd";

    public void myMethod() {
        final DateFormat format = new SimpleDateFormat(FILENAME_DATE_PATTERN);
        // do some formatting
    }
}