@Test (
    alwaysRun = true,
    dataProviderClass = UseCaseProvider.class,
    dataProvider = "getUseCasesNoDependencies",
    skipFailedInvocations = false,
    threadPoolSize = 25,
    invocationCount = 25
  )
  public void testAbc(UseCase useCase) {
    executeUseCase(useCase);
  }