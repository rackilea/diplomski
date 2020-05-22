public interface ProgramLauncher {
    Process exec(String command);
}

...

@Test
public void test() {
    ProgramLauncher mockLauncher = mock(ProgramLauncher.class);
    YourClass underTest = new YourClass(mockLauncher);
    underTest.callMethod();
    verify(mockLauncher).exec("the expected command");
}