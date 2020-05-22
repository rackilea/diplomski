public static void main (String[] args) throws Throwable {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("inner runnable: " + this);   // inner runnable: com.Test$1@34ce8af7
        }
    };


    Thread thread = new Thread(runnable);

    System.out.println("thread:  " + thread); // thread:  Thread[Thread-0,5,main]
    System.out.println("runnable:  " + runnable); // runnable:  com.Test$1@34ce8af7

    thread.start();
    thread.join();
}