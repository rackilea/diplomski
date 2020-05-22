public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void countSellingOrdersInQueueTest(){
        when(orderRepository.countByArticleUserIdAndStateIn(any(), any())).thenReturn(1L);
        String principal = "dummyString";

        Long actualCount = orderService.countSellingOrdersInQueue(principal);

        List<String> expectedStates = Arrays.asList("State 1", "State 2");
        assertThat(actualCount, is(1L));
        verify(orderRepository).countByArticleUserIdAndStateIn(principal, expectedStates);
    }
}