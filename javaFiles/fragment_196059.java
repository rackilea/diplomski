/**
     * The device can't read the response, or there was a 500/503 from the
     * server that can be retried later. The application should use exponential
     * back off and retry.
     */
    public static final String ERROR_SERVICE_NOT_AVAILABLE =
            "SERVICE_NOT_AVAILABLE";