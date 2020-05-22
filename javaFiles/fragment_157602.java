/**
         * Create a DeferredResult with a timeout value and a default result to use
         * in case of timeout.
         * @param timeout timeout value in milliseconds (ignored if {@code null})
         * @param timeoutResult the result to use
         */
        public DeferredResult(Long timeout, Object timeoutResult) {
            this.timeoutResult = timeoutResult;
            this.timeout = timeout;
        }