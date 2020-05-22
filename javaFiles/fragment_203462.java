public class Compressor implements Runnable {

    private final ApplicationArguments appArgs;
    private final String[] args;

    @Autowired
    public Compressor(ApplicationArguments applicationArguments) {
        appArgs = applicationArguments;
        args = applicationArguments.getSourceArgs();
    }

    @Override
    public void run() {
        System.out.println("COMPRESSOR YO");
        System.out.println(Arrays.toString(args));
    }
}