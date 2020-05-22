public class VariableReplaceTest {

    private VariableReplace variableReplace = new VariableReplace();

    @Before
    public void setUp() {
        variableReplace.replace("variable", "foo");
    }

    @Test
    public void testNormal() {
        assertEquals("This variable should be replaced foo", variableReplace.replaceVariables("This variable should be replaced {variable}") );
    }

    @Test
    public void testEscaped() {
        assertEquals("This variable should NOT be replaced {variable}", variableReplace.replaceVariables("This variable should NOT be replaced \\{variable\\}") );
    }

    @Test
    public void testDoubleEscaped() {
        assertEquals("This variable should be replaced \\foo", variableReplace.replaceVariables("This variable should be replaced \\\\{variable}") );
    }

    @Test
    public void testVariableContainsRegexChars() {
        variableReplace.replace("var[iable", "foo");
        assertEquals("This variable should be replaced foo", variableReplace.replaceVariables("This variable should be replaced {var[iable}") );
    }

}