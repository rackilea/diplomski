public class PerformerTest{
    @Test
    public void verifyPerformSomething(){
        WifiStatus dummyWifiStatus = mock(WifiStatus.class);
        doReturn(true).when(dummyWifiStatus).isConnected();

        new Performer(dummyWifiStatus).performSomething();
    }
}