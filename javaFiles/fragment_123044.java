Predicate<Boolean> predicate = new Predicate<Boolean>() {
        @Override
        public boolean apply(Boolean input) {
            return !input;
        }
    };
RetryerBuilder.<Boolean>newBuilder().retryIfResult(predicate)