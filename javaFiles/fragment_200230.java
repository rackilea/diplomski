public static void main(String args[]) throws InterruptedException{
    NumberFormat formatter = new DecimalFormat("#0.00000");

    IOBound io1 = new IOBound();
    IOBound io2 = new IOBound();
    IOBound io3 = new IOBound();
    IOBound io4 = new IOBound();
    IOBound io5 = new IOBound();

    CPUBound cpu1 = new CPUBound();
    CPUBound cpu2 = new CPUBound();
    CPUBound cpu3 = new CPUBound();
    CPUBound cpu4 = new CPUBound();
    CPUBound cpu5 = new CPUBound();

    long scheduleStart = System.currentTimeMillis();
    io1.start();
    io2.start();
    io3.start();
    io4.start();
    io5.start();
    cpu1.start();
    cpu2.start();
    cpu3.start();
    cpu4.start();
    cpu5.start();


    io1.join();
    io2.join();
    io3.join();
    io4.join();
    io5.join();
    cpu1.join();
    cpu2.join();
    cpu3.join();
    cpu4.join();
    cpu5.join();
    long scheduleEnd = System.currentTimeMillis();
    System.out.println("Runtime of all threads: " + formatter.format((scheduleEnd - scheduleStart) / 1000d));
    System.out.println("Processes complete.");
}