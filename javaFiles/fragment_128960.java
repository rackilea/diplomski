public class TestDriver {

    final static String JAVA_EXE = "C:\\...\\java.exe";
    final static String CLASS_BASEPATH = "C:\\...\\java\\bin";

    public static void main(String[] args) throws Exception
    {
        List<String> command = new ArrayList<>();
        command.add(JAVA_EXE.toString());
        command.add("-classpath");
        command.add(CLASS_BASEPATH);
        command.add("TestCmd");
        command.add("Parameter");
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectOutput(new File("c:\\temp\\out.txt"));

        Process process = pb.start();
        PrintStream commandIn = new PrintStream(process.getOutputStream());

        commandIn.println("first input line");
        commandIn.flush();
        commandIn.println("second input line");
        commandIn.flush();

        // give some time to the sub process to finish writing its output
        Thread.sleep(100);

        process.destroy();
    }
}