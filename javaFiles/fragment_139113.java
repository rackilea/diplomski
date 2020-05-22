public class Last90Seconds {
    private Map<LocalDateTime, PriceRequest> priceRequests = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        Last90Seconds app = new Last90Seconds();
        app.simulatePriceRequests();  // thread which continuously simulates a price request

        for (int i = 0; i < 10; i++) {
            Thread.sleep(9000);
            app.reportOnPriceRequests();
        }
    }

    private void simulatePriceRequests() {
        new Thread(new RequestForPriceSimulator()).start();
    }

    private void reportOnPriceRequests() {
        long startNanos = System.nanoTime();
        new ReportSimulator().generateReport();
        long elapsedNanos = System.nanoTime() - startNanos;
        System.out.println("Took " + elapsedNanos / 1000.0 + " milliseconds to generate report.\n\n");
    }

    private LocalDateTime truncateToSeconds(LocalDateTime ldt) {
        return ldt.truncatedTo(ChronoUnit.SECONDS);
    }

    private PriceRequest getPriceTracker(LocalDateTime key) {
        return priceRequests.get(key);
    }

    private PriceRequest getPriceTrackerEvenIfAbsent(LocalDateTime key) {
        return priceRequests.computeIfAbsent(key, v -> new PriceRequest());
    }

    public class RequestForPriceSimulator implements Runnable {

        @Override
        public void run() {
            LocalDateTime rightNow = truncateToSeconds(LocalDateTime.now());
            LocalDateTime ninentySecondsFromNow = rightNow.plusSeconds(90);
            while (rightNow.isBefore(ninentySecondsFromNow)) {

                PriceRequest pt = getPriceTrackerEvenIfAbsent(rightNow);
                double price = ThreadLocalRandom.current().nextDouble() * 10.0;
                pt.addRequest(price);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                rightNow = truncateToSeconds(LocalDateTime.now());
            }

            System.out.println("All done simulating a price request!\n");
        }
    }

    public class ReportSimulator {

        public void generateReport() {
            double lowest = Double.MAX_VALUE;
            double highest = Double.MIN_VALUE;
            double total = 0;
            long requestCounter = 0;

            int keyCounter = 0;
            int validKeyCounter = 0;

            LocalDateTime rightNow = truncateToSeconds(LocalDateTime.now());
            LocalDateTime key = rightNow.minusSeconds(90);
            while (key.isBefore(rightNow)) {
                keyCounter++;

                key = key.plusSeconds(1);

                PriceRequest pt = getPriceTracker(key);
                if (pt == null) {
                    continue;
                }

                validKeyCounter++;
                if (pt.getLowest() < lowest) {
                    lowest = pt.getLowest();
                }

                if (pt.getHighest() < highest) {
                    highest = pt.getHighest();
                }

                total += pt.getTotal();
                requestCounter += pt.getCounter();
            }

            System.out.println("Used " + validKeyCounter + " keys out of " + keyCounter + " possible keys.");
            System.out.println("Total records in last 90 seconds: " + requestCounter);
            System.out.println("Average records per second in last 90 seconds: " + requestCounter / 90);
            System.out.println("Lowest Price in last 90 seconds: " + lowest);
            System.out.println("Highest Price in last 90 seconds: " + highest);
            System.out.println("Total Price in last 90 seconds: " + total);
            System.out.println("Average Price in last 90 seconds: " + (total / requestCounter));
        }
    }

    public class PriceRequest {
        private long counter;
        private double lowest;
        private double highest;
        private double total;

        public PriceRequest() {
            lowest = Double.MAX_VALUE;
            highest = Double.MIN_VALUE;
        }

        public void addRequest(double price) {
            synchronized (this) {

                if (price < lowest) {
                    lowest = price;
                }

                if (price > highest) {
                    highest = price;
                }

                total += price;
                counter++;
            }
        }

        public double getCounter() {
            synchronized (this) {
                return counter;
            }
        }

        public double getLowest() {
            synchronized (this) {
                return lowest;
            }
        }

        public double getHighest() {
            synchronized (this) {
                return highest;
            }
        }

        public double getTotal() {
            synchronized (this) {
                return total;
            }
        }
    }

}