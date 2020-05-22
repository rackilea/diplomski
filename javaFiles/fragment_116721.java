class TestClass {
    private MyDao underTest;

    @Before
    public void setUp() throws SQLException {
        underTest = new MyDao();
        // mocking things...
    }
}