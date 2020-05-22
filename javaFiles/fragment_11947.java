public class DataProcessorTest {

    List<String> TEST_VALUES = Arrays.asList("One", "Two", "Three", "Four", "Five");

    @Test
    public void test() {
        IMocksControl control = EasyMock.createStrictControl();
        ServiceOne serviceOne = control.createMock(ServiceOne.class);
        ServiceTwo serviceTwo = control.createMock(ServiceTwo.class);

        SetMatcher matcher = new SetMatcher(TEST_VALUES, 2);

        for (int i = 0; i < TEST_VALUES.size(); i++) {
            serviceOne.preProcessData(matcher.use());
            serviceTwo.completeTransaction(matcher.use());
        }

        control.replay();

        DataProcessor dataProcessor = new DataProcessor(serviceOne, serviceTwo);
        dataProcessor.processAll(TEST_VALUES);

        control.verify();
    }
}