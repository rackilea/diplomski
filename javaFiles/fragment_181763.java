public class TransactionServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private MessagingService mockMessagingService;
    @Mock
    private CustomerRepository mockCustomerRepository;

    @Test
    public void testMakeTransactionFromSenderToReceiver() {
        // setup the state of the sender and receiver
        Customer sender = new Customer();
        sender.setBalance(5.0);
        Customer receiver = new Customer();
        receiver.setBalance(10.0);
        TransactionService transactionService = new TransactionService(mockMessagingService, mockCustomerRepository);

        transactionService.makeTransactionFromSenderToReceiver(sender, receiver);

        // assert the expected state of the Customer objects
        assertEquals(1.0, sender.getBalance());
        assertEquals(1.0, receiver.getBalance());

        // verify that the repositories were called appropriately once
        // this can be made to be more specific and check the argument that was passed - see Mockito documentation
        verify(mockCustomerRepository, times(2)).save(any());
    }

}