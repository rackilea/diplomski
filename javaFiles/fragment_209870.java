@RunWith(MockitoJUnitRunner.class)
    class GameTester {

    @InjectMocks
    YourService service;
    @Mock
    Repository repository;

    @Test
        void getHours() {
            Hours hours = new Hours();
            hours.setCorrelationId("a-988787888b712ijj-0997878");
            when(repository.get(mockedUUID)).thenReturn(hours);

            Hours persistedBanquet = service.getHours("a-988787888b712ijj-0997878");
            assertEquals(persistedBanquet.getCorrelationId(), hours.getCorrelationId());
        }
}