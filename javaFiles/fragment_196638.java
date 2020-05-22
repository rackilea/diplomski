CountDownLatch countDownLatch = new CountDownLatch(THREAD);
    for(i = 0; i < THREAD; ++i) {
        thr[i] = new Thread(new ThreadSum(first, first + partArray, array, result,countDownLatch));
        thr[i].start();
        first += partArray;
    }
    countDownLatch.await();