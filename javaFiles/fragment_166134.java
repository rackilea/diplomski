class EnrollingServiceTest {
    private EnrollingService enrollingService;

    @Before 
    public void init() {
           enrollingService = new EnrollingService();
    }

    @Test
    public void testEnroll() {
           boolean result = enrollingService.enroll(1l, 1l);
           assertTrue(result);
    ...