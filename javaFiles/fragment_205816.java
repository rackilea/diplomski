public class MyClass {
    private String fileName;

    public MyClass() {
        final Date today = Calendar.getInstance().getTime();
        final DateFormat yymmdd = new SimpleDateFormat("yyMMdd"); 

        this.fileName = "file_" + yymmdd.format(TODAY);
    }
    ...
}