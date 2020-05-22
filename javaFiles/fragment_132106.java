public class CustomStepListener implements StepExecutionListener {

    @Autowired
    private CustomObject customObject;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        // initialize customObject and do other pre set setup
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }