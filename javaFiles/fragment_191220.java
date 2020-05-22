private static boolean skipFlag = false;

    @Before
    public void beforeSkipCount() {
        if(skipFlag)
            Assume.assumeTrue(false);
    }

    @After
    public void afterSkipCount(Scenario scen) {
        if(scen.getSourceTagNames().contains("@SkipCheck") && scen.isFailed())
            skipFlag = true;
    }