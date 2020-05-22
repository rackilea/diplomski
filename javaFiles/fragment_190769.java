int tries, maxRetries = 5;
Connection connection;
do {
    try {
        // initialize connection
    } catch (SocketTimeoutException ex) {
        ++tries;
        if (maxRetries < tries) {
            // exit 
        }
        // sleep for some time between attempts
    }
} while (connection == null);