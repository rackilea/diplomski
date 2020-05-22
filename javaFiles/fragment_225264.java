void connect(String portName) throws Exception {
    Thread thh = new TheThing("blaghname");
    thh.start();
    ...
    // we are ready to interrupt the thread now
    tth.interrupt();
}