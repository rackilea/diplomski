class So57192362ApplicationTests {

    @Test
    void test() {
        MyService service = mock(MyService.class);
        MyListener listener = new MyListener(service);
        Acknowledgment acknowledgment = mock(Acknowledgment.class);
        listener.onMessage(Collections.singletonList(new ConsumerRecord<>("foo", 0, 0L, null, "bar")), acknowledgment);
        verify(service).call("bar");
        verify(acknowledgment).acknowledge();
        verifyNoMoreInteractions(service, acknowledgment);
    }

}