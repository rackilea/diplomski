@Test
public void test() {
    TripSessionManager mockTripSessionManager = mock(TripSessionManager);
    when(mockTripSessionManager.setTo(anyString()).thenAnswer(...);
    when(mockTripSessionManager.setFrom(anyString()).thenAnswer(...);
    TripController controller = new TripController(mockTripSessionManager);
}