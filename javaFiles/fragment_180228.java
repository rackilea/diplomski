public void setupLogger() {
    PrintStream stream=System.out;
    try {
        File file=new File(System.getProperty("user.dir")+"/log.txt");
        file.delete();
        file.createNewFile();
        System.setOut(new WrapperPrintStream(stream,file));
    } catch (IOException e) {
        e.printStackTrace();
    }

    for (int i = 0; i <100 ; i++) {
        System.out.println("Log test "+i);
    }


}
class WrapperPrintStream extends PrintStream{

    private PrintStream defaultOutput;

    public WrapperPrintStream(@NotNull PrintStream out, File file) throws FileNotFoundException {
        super(new PrintStream(new FileOutputStream(file),true), true);
        defaultOutput =out;

    }

    @Override
    public void println(String x) {
        super.println(x);
        defaultOutput.println(x);
    }

    @Override
    public void println() {
        super.println();
        defaultOutput.println();
    }
    //etc for all methods.
}