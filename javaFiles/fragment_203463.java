@Component
public class Compressor implements Runnable {

    private final ApplicationArguments appArgs;
    private final String[] args;

    public Compressor(ApplicationArguments applicationArguments) {
        appArgs = applicationArguments;
        args = applicationArguments.getSourceArgs();
    }
    //...
}