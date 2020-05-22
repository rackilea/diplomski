public class SkipLoginMethodListener implements IConfigurable {
    private static final String SKIP_GROUP = "loginMethod";

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        ITestNGMethod method = testResult.getMethod();
        if (method.isAfterMethodConfiguration() || method.isBeforeMethodConfiguration()) {
            for (String group : method.getGroups()) {
                if (group.equals(SKIP_GROUP)) {
                    System.out.println("skipped " + method.getMethodName());
                    return;
                }
            }
        }

        callBack.runConfigurationMethod(testResult);
    }
}