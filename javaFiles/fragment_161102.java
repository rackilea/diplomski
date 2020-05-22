@Test
    public void testOnOpen() throws Exception {
        System.out.println("OnOpen");

        MyWebClient instance = new MyWebClient();
        instance.connectToWebSocket();

        MyWebClient spy = Mockito.spy(instance);
        spy.OnOpen(instance.getSession());
        Mockito.verify(spy).sendPing();
    }