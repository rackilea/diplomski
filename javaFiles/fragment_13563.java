public void A() throws InterruptedException{
    synchronized (ex3.class) {
        nbA++;
        Thread.sleep(rand.nextInt(500));
        nbA--;
    }
}