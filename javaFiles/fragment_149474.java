static boolean initialized = false;

    @BeforeClass
    public void testSetup() {
        if (!initialized) {
            initialized = true;
            System.out.println("Doing setup");
        }
    }