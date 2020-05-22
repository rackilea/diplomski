void connect(String portName) throws Exception {
    Thread thh = new TheThing("blaghname");
    thh.start();
    ...
    // we are ready to kill the thread now
    tth.shutdown = true;
}