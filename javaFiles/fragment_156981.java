@Test
public void runShouldInvokeSubscriberInit() {

    // Given
    Subscriber mockSubscriber = mock(Subscriber.class);
    WebAdaptor adaptor = new WebAdaptor(mockSubscriber);  // Use the new constructor

    // When
    adaptor.run();

    // Then
    verify(mockSubscriber).init();
}