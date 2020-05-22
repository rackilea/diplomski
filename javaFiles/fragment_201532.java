final BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1024);
final BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1024);

final Random r = new Random();          

Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        try {
            //don't create threads here, this is already a thread, just produce the numbers
            //If the queue is full `BlockingQueue.put()` will block until the consumer consume numbers.

            //Producer even number
            queue1.put(r.nextInt(50)*2);

            //Producer odd number
            queue2.put(r.nextInt(50)*2 + 1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}, 0, 2000);

//Now we create the threads that will take numbers from the producer. Don't worry about the `while (true)`, it is not wasting resources because `BlockingQueue.take()` will block the thread until something is produced.

//Consumer 1
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("Thread-1: " + queue1.take());

                //Or update some UI component
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}).start();

//Consumer 2
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("Thread-2: " + queue2.take());

                //Or update some UI component
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}).start();