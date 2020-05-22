public class CultureMachineTestCases{

    CultureMachineAssignment testObj=new CultureMachineAssignment ();

    @Before
    public void init() throws IOException{
        testObj.insertDataIntoSet();
        testObj.addKeywords("video1");

    }

    @Test
    public void testVideo() throws IOException {
         assertEquals("video1", testObj.search("abcd"));

    }
}