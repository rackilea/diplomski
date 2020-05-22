thread1.start();
thread2.start();
thread3.start();
thread4.start();

while (true) {
    try {
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        break;
    } catch (InterruptedException e) {
        e.printStackTrace();
}