if ((status >= 100) && (status < 200)) {
    if (LOG.isInfoEnabled()) {
        LOG.info("Discarding unexpected response: " +
            this.statusLine.toString()); 
    }
    this.statusLine = null;
}