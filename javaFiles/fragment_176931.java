public class Test {
    static Terser pcd01 = null;
    @BeforeClass
    public static void getData() throws Exception {
        // Make the connection to PM.service
        TCPServer tc = new TCPServer();
        String [] values = tc.returnData();

        // Make the terser and return it.  
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getGenericParser();
        Message hapiMsg = p.parse(data);
        pcd01 = new Terser(hapiMsg);
    }
    @Test
    public void test_1() throws Exception {
        // Do stuff with pcd01
    }

    @Test
    public void test_2() throws Exception {
        // Do stuff with pcd01
    }

    @Test
    public void test_3() throws Exception {
        // Do stuff with pcd01
    }
}