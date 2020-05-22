@Override
public void publish(LogRecord record) {
    if (isLoggable(record)) {
        try {
            final String val = getFormatter().format(record);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    try {
                        getArea().append(val);
                    } catch (RuntimeException e) {
                        reportError(val, e, ErrorManager.WRITE_FAILURE);
                    }
                }
            });
        } catch (RuntimeException e) {
            reportError(null, e, ErrorManager.WRITE_FAILURE);
        }
    }
}

private JTextArea getArea() {
    if (!SwingUtilities.isEventDispatchThread()) {
       throw new IllegalThreadStateException(Thread.currentThread().toString());
    }
    return null; //@todo Implement this.
}