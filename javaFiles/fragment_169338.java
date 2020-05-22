public class MyTestListener extends TestListenerAdapter implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        updateInternalTool(tr, true);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        updateInternalTool(tr, false);
    }

    private void updateInternalTool(ITestResult tr, boolean success) {
        InternalTool annotation = tr.getMethod().getConstructorOrMethod().getMethod().getAnnotation(InternalTool.class);
        for (String id : annotation.ids()) {
            System.out.println(String.format("Test with id [%s] is [%s]", id, success ? "successful" : "failed"));
        }
    }
}