Session s = Session.getInstance(props);
Logger.getLogger("javax.mail").addHandler(new Handler() {

    @Override
    public void publish(LogRecord record) {
        System.out.println(new SimpleFormatter().format(record));
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }
});
s.setDebug(true);