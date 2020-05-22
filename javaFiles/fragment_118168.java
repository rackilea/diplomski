public static <T> T processDbAction(Callable<T> dbAction) {
    int count = 0;
    int maxTries = getMongoQueryRetries();
    while (count < maxTries + 1) {
        try {
           return dbAction.call();
        } catch (MongoTimeoutException | MongoSocketReadTimeoutException | MongoSocketClosedException | MongoSocketReadException | MongoNotPrimaryException e) {
            if (++count == maxTries) {
                LOG.error(e.getMessage());
                throw e;
            }
        } catch (MongoSocketException | MongoServerException e) {
            if (++count == maxTries) {
                LOG.error(e.getMessage());
                throw e;
            }
        } catch (Throwable e) {
            LOG.error(e.getMessage());
            throw e;
        }
    }
}