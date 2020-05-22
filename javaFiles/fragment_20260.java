try {
    Thread.sleep(10000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

Mockito.verify(mockJmsTemplate, Mockito.times(4)).send(messageCaptor.capture());