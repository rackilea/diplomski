public static TestRun newTestRun(Test test){
    TestRun run = new TestRun();
    run.setPerformedTest(test);
    test.getAppearsOnTestRuns().add(run);
    return run;
}