try {
    while (true) {
        Thread.sleep(4000);
        Bread bread = new Bread(id++);
        synchronized(Basket.breadList) {
            while (Basket.breadList.size() == 20) {
               Basket.breadList.wait();
            }
            Basket.breadList.add(bread);
            Basket.breadList.notifyAll();        
        }
    }
} catch (InterruptedException e) {
}