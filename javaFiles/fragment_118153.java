public static void main(String[] args) throws Exception {
    final long start = System.currentTimeMillis();
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            double hours = (System.currentTimeMillis() - start) / 3600000d;
            System.out.println("Please enter the hourly rate");
            double hourlyRate = new Scanner(System.in).nextDouble();
            System.out.format("Program ran for %01.3f hours and cost $%02.2f", hours, hourlyRate * hours);
        }
    }));
    Thread.sleep(Long.MAX_VALUE); // Sleep "forever"
}