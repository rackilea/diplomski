//class to be mocked
@Mock
ServerRequest mockReq;

@Before
public void setup(){
    //get the activity instance
    Registration reg = mActivityRule.getActivity();
    //make sure the actual method to be mocked does nothing, By default it should do nothing anyway but for some reason  not for me 
    doNothing().when(mockReq).InformationRequest(ArgumentMatchers.anyMap(),anyString(),ArgumentMatchers.<ServerInterface>any());
    //set up an argument catcher
    captor = ArgumentCaptor.forClass(ServerInterface.class);
    //inject the mock into the activity
    reg.serverRequest = mockReq;
}