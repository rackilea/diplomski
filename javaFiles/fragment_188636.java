@Before
public void setMinimalMockingExpectations() throws IOException
{
    oldIn = System.in;
    oldOut = System.out;
    pipe = new PipedOutputStream();
    testIn = new PipedInputStream(pipe);
    mockOut = context.mock(PrintStream.class);
    System.setOut(mockOut);
    System.setIn(testIn);

    expectQuestion();
}

private void expectQuestion()
{
    Expectations exp = new Expectations()
    {
        {
            one(mockOut).println(main.QUESTION);
        }
    };
    context.checking(exp);

}

@After
public void reset()
{
    System.setIn(oldIn);
    System.setOut(oldOut);
}

@Test
public void fileChoiceReturnsFalse() throws IOException
{
    String FILE = "F\n";
    pipe.write(FILE.getBytes());

    assertFalse(main.promptStringOrFile());

    context.assertIsSatisfied(); // can avoid this call by using the right
                                    // test runner
}