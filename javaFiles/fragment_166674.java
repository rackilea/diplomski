@BeforeClass(alwaysRun = true)
public void beforeClass(ITestContext testContext, @Optional String step, @Optional String suiteLoopData,
        @Optional String group) throws Exception
{
    boolean wasShowStopperFound = APIUtils.loadShowStopper();
    if (wasShowStopperFound){
        Thread.currentThread().interrupt();
        return;
    }
}