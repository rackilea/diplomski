public class AddTest {
    @Test
    public void addCalcNodeTest() {
        // get a value from our class
        Add myAdd = new Add();
        ObjectNode addedNode = myAdd.addCalcNode(1, 2);
        // test that that value is correct
        // I don't know how your ObjectMapper works, so I'll just do this to demonstrate
        ObjectNode expected = (new ObjectMapper()).createObjectNode();
        expected.put("result", 3);
        // the assert functions are the core of JUnit, for testing that your function does
        // what you want it to. assertEquals() is the most basic of them.
        assertEquals(expected, addedNode);
    }
}