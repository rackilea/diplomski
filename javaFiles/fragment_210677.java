@RepeatedTest(value = nrOfIterations)
void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
    final int runNr = repetitionInfo.getCurrentRepetition() - 1;
    test1(runNr);
    test2(runNr);
    assertEquals(3, repetitionInfo.getTotalRepetitions());
}