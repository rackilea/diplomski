public class GNUMakeExecutor {

    private static final String GNU_MAKE = "make";

    public static void main(String[] args) throws Exception {
        File sourceRootDir = new File("/home/dev/project_root");
        String makeFileName = "MyCustomMakeFile";
        List<String> command = new ArrayList<>();
        command.add(GNU_MAKE);
        // and add/check some flag to skip, in case of pre-compiled headers
        if( Runtime.getRuntime().availableProcessors() > 1 ) {
            command.add("-j"+Runtime.getRuntime().availableProcessors());
        }
        if(null != makeFileName && makeFileName.length() > 0) {
            command.add("-f");
            command.add(makeFileName);
        }
        String path = System.getenv("PATH") + File.pathSeparator +  "/opt/my_additional_util/bin";
        ProcessBuilder pb = new ProcessBuilder().directory(sourceRootDir)
                .command(command).redirectError(Redirect.INHERIT).redirectOutput(Redirect.INHERIT);
        pb.environment().put("PATH", path);
        Process makeProcess = pb.start();
        int exitCode = makeProcess.waitFor();
        if(exitCode != 0)
            System.err.println("Build failed, exit code: " + exitCode );
        else
            System.out.println("Build success");
    }

}