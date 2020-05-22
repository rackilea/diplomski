class Task1 implements Runnable (){
    public run(){
        System.out.println("Runnable 1");
    }
}

class Task2 implements Runnable (){
    public run(){
        System.out.println("Runnable 2");
    }
}

// create two threads, one for each task
Thread t1 = new Thread(new Task1());
Thread t2 = new Thread(new Task2());

// start the threads (should print the two messages)
t1.start();
t2.start();