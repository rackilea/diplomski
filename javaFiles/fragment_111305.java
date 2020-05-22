void afterInvocation(IInvokedMethod method, ITestResult result) {
    if (result.getThrowable().getCause() instanceof IllegalArgumentException) {
        System.out.println("This is expected.");
        result.setThrowable(null);
        result.setStatus(SUCCESS); // If you want to change the status
    } else {
        System.out.println("Unexpected exception");
    }
}