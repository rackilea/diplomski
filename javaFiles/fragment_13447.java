@RunWith(JMockit.class)
public class StackOverflowTest {

    // empty injectable just so that the processor can be created
    @Injectable
    private List<ValueProcessor> valueProcessors;

    // availableDuringSetup = true to be able to modify the processor
    @Tested(availableDuringSetup = true)
    private Processor processor;

    @Before
    public void setUp() throws Exception {
        // create new instance of the processor (now the valueProcessors list is a real list)
        processor = new Processor(Collections.singletonList(processor -> Collections.singletonList(new Response())));
    }

    @Test
    public void testProc() {
        assertThat(processor.proc(null), hasSize(1));
    }

}