// start other threads
for (int i = 0; i < wclw.length; i++) {
    wclw[i] = new Test2(url, i + 1);
    wclw[i].start();
}
// do other stuff in the test thread if necessary
...
// come back and wait for them all to finish
for (int i = 0; i < wclw.length; i++) {
    wclw[i].mthread.join();
}