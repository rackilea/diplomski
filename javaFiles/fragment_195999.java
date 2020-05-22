class MockLoginHelper extends MockUp<LoginHelper> {
    @Tested
    private SDKConfiguration config;

    @Mock
    public void relogin() {}

    @Mock
    public SDKConfiguration getSDKConfig() {
        System.out.println("");
        System.out.println("Mocked " + this.getClass().getSimpleName());
        if (config == null) {
            try {
                relogin();
            } catch (Exception e) {
                System.err.println("failed to relogin");
                e.printStackTrace();
            }
        }
        return config;
    }
}