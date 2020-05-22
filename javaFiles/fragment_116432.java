public class TestExecutionListener implements IInvokedMethodListener {
    private Map<Integer, Deque<String>> logsMap = new HashMap<Integer, Deque<String>>();

    public void log(IInvokedMethod iInvokedMethod, String log) {
        if(!logsMap.containsKey(iInvokedMethod.getId())) {
            logsMap.put(iInvokedMethod.getId(), new ArrayDeque<String>());
        }

        logsMap.get(iInvokedMethod.getId()).add(log);
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log(iInvokedMethod, "Testing : " + iInvokedMethod.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log(iInvokedMethod, "Successfully Tested : " + iInvokedMethod.getTestMethod().getMethodName());

        Deque<String> logs = logsMap.get(iInvokedMethod.getId());
        while(!logs.isEmpty()) {
            System.out.println(logs.poll());
        }
    }
}