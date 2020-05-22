Test test = new Test("qwerty");
// start the test thread running in the background
test.start();
// do other stuff on the main thread
...
// wait for the test thread to finish
test.mThread.join();