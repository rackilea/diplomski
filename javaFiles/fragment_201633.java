MyActivityLogic mLogic; // The CUT, Component Under Test
MyApplication mMyApplication; // Will be mocked

protected void setUp() {
    // Create the mock using mockito.
      mMyApplication = mock(MyApplication.class);
    // "Inject" the mock into the CUT
      mLogic = new MyActivityLogic(mMyApplication);
}

public void testOnClickShouldSetNewStateOnAppContext() {
    // Test composed of the three A's        
    // ARRANGE: Most stuff is already done in setUp

    // ACT: Do the test by calling the logic
    mLogic.onClick(null);

    // ASSERT: Make sure the application.setNewState is called
    verify(mMyApplication).setNewState();
}