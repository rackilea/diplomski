public Object handle(Invocation invocation) throws Throwable {
  // [detect doAnswer stubbing]
  VerificationMode verificationMode = mockingProgress.pullVerificationMode();
  // [check Matcher state]

  // if verificationMode is not null then someone is doing verify()
  if (verificationMode != null) {
    // We need to check if verification was started on the correct mock
    // - see VerifyingWithAnExtraCallToADifferentMockTest (bug 138)
    if (((MockAwareVerificationMode) verificationMode).getMock() == invocation.getMock()) {
      VerificationDataImpl data = createVerificationData(invocationContainerImpl, invocationMatcher);
      verificationMode.verify(data);
      return null;
    } else {
      // this means there is an invocation on a different mock. Re-adding verification mode
      // - see VerifyingWithAnExtraCallToADifferentMockTest (bug 138)
      mockingProgress.verificationStarted(verificationMode);
    }
  }

  // [prepare invocation for stubbing]
}