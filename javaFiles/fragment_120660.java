while (!isCancelled()) {
    counter %= arrNames.length;
    // System.out.format("Counter : %d%n", counter);
    publish(arrNames[counter]);
    try {
        Thread.sleep(30); // throws
    } catch (InterruptedException ie) {
        ie.printStackTrace();
    }
    counter++;
}