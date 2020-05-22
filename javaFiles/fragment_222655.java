try {
        restTemplate.exchange(...);
    }
    catch (RestClientException e) {
        // implies error is related to i/o. 
        if (e instanceof ResourceAccessException) {
            // java.net.ConnectException will be wrapped in e with message "Connection timed out".
            if (e.contains(ConnectException.class)) {
                // handle connection timeout excp
            }
        } else if (e instanceof HttpClientErrorException) {
            // Handle all HTTP 4xx error codes here;

        } else if (e instanceof HttpServerErrorException) {
            // Handle all HTTP 5xx error codes here
        }
    }