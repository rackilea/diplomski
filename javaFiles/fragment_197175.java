@Component("sourceSelectionReader")
@StepScope // required, also works with @Scope("step")
public class SourceSelectionReaderImpl implements ItemReader<MyThing> {
    private final long myParam;

    // Not lazy, specified param name for the jobParameters
    @Autowired
    public SourceSelectionReaderImpl(@Value("#{jobParameters['myParam']}") final long myParam) {
        this.myParam = myParam;
    }

    // the rest of the reader...
}