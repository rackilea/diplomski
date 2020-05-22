private void checkRateLimit(QueryResult result) {

    if (result.getRateLimitStatus().getRemaining() <= 0){
        try {
          Thread.sleep(result.getRateLimitStatus().getSecondsUntilReset() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}