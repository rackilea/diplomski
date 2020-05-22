public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH'h':mm'm':ss's'");
    Thread.sleep(10000);
    long end = System.currentTimeMillis();
    long difference = end - start;
    System.out.println("Start :" + dateFormat.format(start) );
    System.out.println("End :" + dateFormat.format(end) );
    String format = String.format("%d min, %d sec", 
            TimeUnit.MILLISECONDS.toMinutes(difference),
            TimeUnit.MILLISECONDS.toSeconds(difference) - 
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference))
        );
    System.out.println(format);
}