@Test
public void testInvoke() throws Exception {

    final CountDownLatch countDownLatch = new CountDownLatch(1); //1 is how many invokes we are waiting for

    JustAClass justAClass = new JustAClass();
    JustAClass.JustACallBack callBack = new JustAClass.JustACallBack() {
        @Override
        public void callFunc(final JustAClass.JustAResult result) {
            assertNotNull("Result should not be null", result);
            assertTrue("Result should be instance of JustAResultReal", result instanceof JustAClass.JustAResultReal);
            countDownLatch.countDown();
        }
    };

    justAClass.threadFunc(callBack);
    if(!countDownLatch.await(1200, TimeUnit.MILLISECONDS)){
        fail("Timed out, see log for errors");
    }

}