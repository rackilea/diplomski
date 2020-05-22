@InjectMocks
private Wrapper testedObject = new Wrapper ();

private List<Strategy> mockedStrategies;

@Mock
StrategyA strategyA;

@Mock
StrategyB strategyB;

@Before
public void setup() throws Exception {
    mockedStrategies = Arrays.asList(strategyA, strategyB);
    wrapper.setStrategies(mockedStrategies);
}