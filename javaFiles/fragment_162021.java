@PrepareForTest({InternalUtils.class})
@RunWith(PowerMockRunner.class)
public class InternalServiceTest { //Note the renaming of the test class.
   public void testProcessOrder() {
        //Variables
        InternalService is = new InternalService();
        Order order = mock(Order.class);

        //Mock Behavior
        when(order.isSuccessful()).thenReturn(true);
        mockStatic(Internalutils.class);
        doNothing().when(InternalUtils.class); //This is the preferred way
                                               //to mock static void methods.
        InternalUtils.sendEmail(anyString(), anyString(), anyString(), anyString());

        //Execute
        is.processOrder(order);            

        //Verify
        verifyStatic(InternalUtils.class); //Similar to how you mock static methods
                                           //this is how you verify them.
        InternalUtils.sendEmail(anyString(), anyString(), anyString(), anyString());
   }
}