Thread1 ->run {
    while(canIrun) {
    executeTask(taskQueue1.next());
    notifyThread2();
    waitForThread2Signal();
   }
  }

  Thread2 -.run {
   while(canIrun) {
    waitForThread1Signal();
    executeTask(taskQueue2.next());
    notifyThread1();
   }
  }