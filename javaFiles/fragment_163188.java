for(int i=0;i<10;i++){          
    MyThread thread = new MyThread(i*10, ""+i,latch);
    exec.execute(thread);
}
try {
    latch.await();
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}