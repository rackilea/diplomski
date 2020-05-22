thread.start();
try {
    thread.join();    
} catch (InterruptedException e) {
    e.printStackTrace();
}