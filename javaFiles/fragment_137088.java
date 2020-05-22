@Mock
ClientFactory clientFactoryMock;
@Mock
SoapServiceClient soapServiceClientMock; 

@Test
public void myTest(){
    ...
   //add record for soapServiceClientMock
   Mockito.when(soapServiceClientMock.xxx()).return(...);
   // and return soapServiceClientMock as getInstance() is invoked        
   Mockito.when(clientFactoryMock.getInstance()).return(soapServiceClientMock);
}