public static void main(String[] args) {
    Thread t1 = new Thread() { 
        public void run() {
            ...
        }
    };
    Thread t2 = new Thread() { 
        public void run() {
            ...
        }
    };

    t1.start();
    t2.start();

    t1.join();
    t2.join();   
}