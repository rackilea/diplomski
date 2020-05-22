public ReturnType foo() {
    return foo(0);
}

private ReturnType foo(int recursionCounter) {
    try {
        // Try to do something...
        return doSomething();
    } catch (Exception e){
        if (recursionCounter == 5) {
            // Issue not fixed within 5 retries, throw the error
            throw e;
        } else {
            attemptToFixTheIssue();
            return foo(recursionCounter + 1);
        }
    }
}