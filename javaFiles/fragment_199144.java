class TestClass {
    @Parameters({ "parm1" })
    @BeforeClass
    void setup(@Optional("Default Value") String parm1) {
        System.out.println("parm1 = " + parm1);
    }
}