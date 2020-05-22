@Override
    public boolean remove(Exchange exchange, Object key) {
        Throwable caught = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
        if (exchange.getException() == null && caught != null) {
            logger.info("Exception was handled, not removing key");
            return false;
        } else {
            // ... remove the message
        }
     }