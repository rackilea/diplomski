/**
   * Triggered upon the failure of a test
   */
  public void onTestFailure( ITestResult testResult ) {
      LOG.fail( testResult.getThrowable() );
 }