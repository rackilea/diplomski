public class MyHandler  {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Flux<String> handle() {
        return Mono.defer(() -> rates().delayElements(Duration.ofSeconds(5)).collectList())
                .repeat()
                .map(value -> {
                    try {
                        return objectMapper.writeValueAsString(value);
                    } catch (JsonProcessingException e) {
                        return null;
                    }
                });
    }

    private Flux<Rate> rates() {
        return Flux.just(new Rate("a"), new Rate("b"), new Rate("c"));
    }

    public static void main(String[] args) {
        new MyHandler().handle()
                .subscribe(str -> System.out.println(str + ", time now - " + Instant.now().toEpochMilli()));
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Rate {
        private final long timestamp;
        private String symbol;
        private final double rate;

        public Rate(String symbol) {
            this.symbol = symbol;
            timestamp = Instant.now().toEpochMilli();
            rate  = new BigDecimal(Math.random() * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Creating Rate " + timestamp);
        }
        // getters and setters

        public long getTimestamp() {
            return timestamp;
        }
        public String getSymbol() {
            return symbol;
        }
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
        public double getRate() {
            return rate;
        }
    }
}