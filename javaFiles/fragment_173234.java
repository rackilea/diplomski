@Test
    public void test() {
        logWrapper.flushData();
        System.out.println("GeneralLogReadWriteTest test()");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException e");
        }
    }