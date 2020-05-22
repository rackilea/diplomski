@Before
public void setUp(Scenario scenario) throws Exception{

    tags = (ArrayList<String>) scenario.getSourceTagNames();
    System.out.println("At Hooks: " + scenario.getId());
    Iterator ite = tags.iterator();

    while (ite.hasNext()) {

        String buffer = ite.next().toString();
        if (buffer.startsWith("<tagOfATestCase>")) {

            Field f = scenario.getClass().getDeclaredField("testCase");
            f.setAccessible(true);
            TestCase r = (TestCase) f.get(scenario);

            List<PickleStepTestStep> testSteps = r.getTestSteps().stream().filter(x -> x instanceof PickleStepTestStep)
                    .map(x -> (PickleStepTestStep) x).collect(Collectors.toList());

            for (PickleStepTestStep ts : testSteps) {

                System.out.println(ts.getStepText());//will print your test case steps

            }

        }

    }