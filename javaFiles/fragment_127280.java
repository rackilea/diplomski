void step1() {
    try {
        ...
    } catch(Exception e) {
        throw new StepExecutionException("Step 1", e);
    }
}