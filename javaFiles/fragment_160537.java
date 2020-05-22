public int fillToCrLf(InputStream inputStream, byte[] buffer) throws IOException {
    int n = 0;
    int bite;
    if (logger.isDebugEnabled()) {
        logger.debug("Available to read: " + inputStream.available());
    }
    try {
         ...
    }
    catch (SoftEndOfStreamException e) {
        throw e;
    }
    catch (IOException e) {
        publishEvent(e, buffer, n);
        throw e;
    }
    catch (RuntimeException e) {
        publishEvent(e, buffer, n);
        throw e;
    }
}