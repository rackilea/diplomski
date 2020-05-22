public void whenTestModeIsEnabledThenReturnDone() {
     setPhoneIntoTestMode();
     String actual = subject.handleUser(null);
     assertEquals(actual, "done");
}

public void whenTestModeIsDisabledThenReturnFailed() {
     setPhoneIntoLiveMode();
     String actual = subject.handleUser(null);
     assertEquals(actual, "failed");
}