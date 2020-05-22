public class AverageReport implements ISuiteListener {
    @Override
    public void onStart(final ISuite iSuite) {
    }

    @Override
    public void onFinish(final ISuite iSuite) {
        // group runtimes per method
        Map<String, List<Double>> runtimes = new HashMap<>();
        for (IInvokedMethod method : iSuite.getAllInvokedMethods()) {
            ITestResult result = method.getTestResult();
            long runtime = result.getEndMillis() - result.getStartMillis();
            String methodName = method.getTestMethod().getMethodName();
            runtimes.computeIfAbsent(methodName, (name) -> new ArrayList<>())
                    .add((double) runtime);
        }

        // calculate averages and report
        averages.forEach((methodName, value) ->
            value.stream()
                 .mapToDouble(a -> a)
                 .average()
                 .ifPresent(avg -> 
                       // Put your reporting code here
                       System.err.println(
                           methodName + " average runtime is " + avg + "ms"
                       )
            ));
    }
}