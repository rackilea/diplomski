public class MyTestCase{
    @Test
    public void testValidObject(){
        Service service = new Service();
        service.addValidator(new IMyObjectValidator() {
                  boolean validate(MyObject myObject) {
                    // some assertions here
                    return true; 
                  }
               });

        service.doService(mockRequest, mockResponse);

        // some final assertions here
    }
}