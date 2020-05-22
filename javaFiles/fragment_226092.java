public static <T> Future<T> getFirstDone(List<Future<T>> futures) {
    while (true) {
        for (Future<T> future : futures) {
            if (future.isDone()) {
                return future;
            }
        }

        // Break if necessary infinite loop here once it reaches certain timeout.
    }
}