public class TestPropertyParser {

    private Set<String> literals;
    private Set<String> params;

    private void assertLiteralsContains(String string) {
        assertTrue(this.literals.contains(string));
    }

    private void assertParamsContains(String string) {
        assertTrue(this.params.contains(string));
    }

    private void assertResultSizes(Integer paramSize, Integer literalSize) {
        if (paramSize != null) {
            assertNotNull(this.params);
            assertEquals((int) paramSize, this.params.size());
        } else {
            assertNull(this.params);
        }
        if (literalSize != null) {
            assertNotNull(this.literals);
            assertEquals((int) literalSize, this.literals.size());
        } else {
            assertNull(this.literals);
        }
    }

    private void parseAndSet(String stringToParse) {
        ParsedParameters result = PropertyParser.parseParametersAndLiterals(stringToParse);
        this.literals = result.getLiterals();
        this.params = result.getParameters();
    }

    @Before
    public void setup() {
        this.params = new HashSet<String>();
        this.literals = new HashSet<String>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParserInvalidParameterQuoteLeft() {
        parseAndSet("'${Invalid Parameter}");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParserInvalidParameterQuoteRight() {
        parseAndSet("${Invalid Parameter}'");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParserInvalidParameterSpaces() {
        parseAndSet(" ${Invalid Parameter}");
    }

    @Test
    public void testParserValidStrings() {
        // Initialization condition.
        assertResultSizes(0, 0);

        // Null string.
        parseAndSet(null);
        assertResultSizes(0, 0);

        // Empty string.
        parseAndSet(new String());
        assertResultSizes(0, 0);

        // Single parameter.
        parseAndSet("... ${_A_}, $yada yada'$[]' '${");
        assertResultSizes(1, 0);
        assertParamsContains("_A_");

        // Many parameters and one literal.
        parseAndSet("... ${_A_}, ${12345}, '${Literal}''${Non_Literal_Left} ${Non_Literal_Right}' ");
        assertResultSizes(4, 1);
        assertParamsContains("_A_");
        assertParamsContains("12345");
        assertParamsContains("Non_Literal_Left");
        assertParamsContains("Non_Literal_Right");
        assertLiteralsContains("Literal");

        // Nested literal and odd bracket placements.
        parseAndSet("''${Totally}''$}{$'${Single}");
        assertResultSizes(1, 1);
        assertParamsContains("Single");
        assertLiteralsContains("Totally");

        // Subset of ASCII characters.
        parseAndSet("`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?");
        assertResultSizes(0, 0);

        // Illegal characters in literal.
        parseAndSet("'${This literal is completely valid}'");
        assertResultSizes(0, 1);
        assertLiteralsContains("This literal is completely valid");

        // Test incomplete literal, no closure.
        parseAndSet("'${This literal is never closed");
        assertResultSizes(0, 0);

        // Test incomplete parameter from left.
        parseAndSet("${Never_Closed");
        assertResultSizes(0, 0);

        // And again... with a parameter at the end.
        parseAndSet("${Never_Closed${But_This_Is}");
        assertResultSizes(1, 0);
        assertParamsContains("But_This_Is");

        // Empty parameter.
        parseAndSet("${}");
        assertResultSizes(0, 0);

        // Restarting a new parameter within an already open parameter.
        parseAndSet("${Perfectly valid${a}");
        assertResultSizes(1, 0);
        assertParamsContains("a");

        // Variation of the above with quotes.
        parseAndSet("'${Perfectly valid'${a}");
        assertResultSizes(1, 0);
        assertParamsContains("a");

        // Variation of the above with quotes.
        parseAndSet("${Perfectly valid'${a}");
        assertResultSizes(1, 0);
        assertParamsContains("a");

        // Variation of the above with quotes.
        parseAndSet("${Perfectly valid${a}'");
        assertResultSizes(1, 0);
        assertParamsContains("a");

        // Variation of the above with quotes.
        parseAndSet("${Perfectly valid'${a}'");
        assertResultSizes(0, 1);
        assertLiteralsContains("a");

        // Variation of the above with spaces.
        parseAndSet(" ${ Perfectly valid${a} ");
        assertResultSizes(1, 0);
        assertParamsContains("a");

        // TODO Determine what the desired behavior is for nested literals and parameters.

        // Test nested parameter in literal.
        parseAndSet("'${Nested ${Parameter}}'");
        assertResultSizes(1, 0);
        assertParamsContains("Parameter");

        // Nested parameter.
        parseAndSet("${Nested_${Parameter}}'");
        assertResultSizes(1, 0);
        assertParamsContains("Parameter");

        // Literal nested in a parameter.
        parseAndSet(" ${Nested'${Literal}'}");
        assertResultSizes(0, 1);
        assertLiteralsContains("Literal");
    }
}