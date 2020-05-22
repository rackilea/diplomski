@Test
public void testReturnChain() throws Exception {
    Example example = new Example() {
        public String getValue() {
            return null;
        }
    };
    Example mockExample = spy(example);
    PowerMockito.doAnswer(new Answer<String>() {
        private final Queue<String> values = new LinkedList<String>(Arrays.asList("firstValue", "secondValue"));

        public String answer(InvocationOnMock invocationOnMock) throws Throwable {
            return values.poll();
        }
    }).when(mockExample, "getValue");

    System.out.println(mockExample.getValue());
    System.out.println(mockExample.getValue());
    System.out.println(mockExample.getValue());
}