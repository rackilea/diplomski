for (Job aJob : jobs) {
    try {
        step1();
        step2();
        ...
    } catch (StepExecutionException see) {
        see.raiseTicket();
    }
}