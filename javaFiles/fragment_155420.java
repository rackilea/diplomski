final Logger myLog4jLogger = Logger.getLogger(getClass());

System.setOut(new PrintStream(new ByteArrayOutputStream() {
    @Override
    public synchronized void write(byte[] pB, int pOff, int pLen) {
        super.write(pB, pOff, pLen);
        myLog4jLogger.info(toString());
        reset();
    }
}));

System.setErr(new PrintStream(new ByteArrayOutputStream() {
    @Override
    public synchronized void write(byte[] pB, int pOff, int pLen) {
        super.write(pB, pOff, pLen);
        myLog4jLogger.warn(toString());
        reset();
    }
}));