import java.io.IOException;

class StartExcel {
    public static void main(String args[])
        throws IOException
    {
        String fileName = "c:\\temp\\xls\\test2.xls";
        String[] commands = {"cmd", "/c", "start", "\"DummyTitle\"",fileName};
        Runtime.getRuntime().exec(commands);
    }
}