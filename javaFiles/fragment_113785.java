class Abc {

    MyObject object; 

    @Before
    public void setUp() {

        object = new MyObject();
    }

    @Test
    public void test() {
        // Use object
    }
}