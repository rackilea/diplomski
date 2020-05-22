@Test
    @PrepareForTest({MyClass.class})
    public void test() throws Exception {
        StaticLearner mockLearner = Mockito.mock(StaticLearner.class);

        PowerMockito.whenNew(StaticLearner.class)
                .withNoArguments()
                .thenReturn(mockLearner);

        MyClass myClass = new MyClass(true, StaticLearner.class);
        myClass.process();
    }