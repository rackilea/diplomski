try {
        ...
} catch (Exception e) {
        if (!(e instanceof java.net.SocketTimeoutException || e instanceof UnknownHostException
            || e instanceof SocketException)) {
                Logging.logger().log(Level.SEVERE,
                Logging.getMessage("URLRetriever.ErrorReadingFromConnection", this.url.toString()), e);
        }
        throw e;
}