private static int skipCount = 0;
private static final int ALLOWED_FAIL_TEST_COUNT = 2;

@Before
public void beforeSkipCount() {
    if(skipCount == ALLOWED_FAIL_TEST_COUNT)
        Assume.assumeTrue(false);
}

@After
public void afterSkipCount(Scenario scen) {
    if(scen.isFailed())
        skipCount++;
}