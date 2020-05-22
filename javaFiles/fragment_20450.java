public StreamHandler buildseh() {
    final StreamHandler seh = new StreamHandler(System.err, formatter) {
        @Override
        public synchronized void publish(final LogRecord record) {
            super.publish(record);
            flush();
        }
    };
    seh.setLevel(Level.SEVERE); // Default StdErr Setting
    return seh;
}