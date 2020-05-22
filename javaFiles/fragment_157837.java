Handler handler = mock(Handler.class);
CountDownLatch finished = new CountDownLatch(1);

doAnswer(invocation -> {
    finished.countDown();
    return null;
}).when(handler).callHandler();

TestClass testClass = new TestClass(executor, handler);

testClass.doSomething("thisThing");

boolean ended = finished.await(10, TimeUnit.SECONDS);

assertThat(ended).isTrue();

verify(handler).callHandler();