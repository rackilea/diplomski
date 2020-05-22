@Retryable(value = ArithmeticException.class, maxAttempts = 5, backoff = @Backoff(delay = 3000))
    public String getInfo() {
        try {
            System.out.println("How many time will this be printed?");
            return "Hello" + 4 / 0;
        } catch (ArithmeticException ex) {
            // will be retried
            throw ex;
        }
    }