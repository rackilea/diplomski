final Queue<Integer> queue1 = new ConcurrentLinkedQueue<Integer>();
final Queue<Integer> queue2 = new ConcurrentLinkedQueue<Integer>();

final Random r = new Random();

Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {             
    @Override
    public void run() {
        //Thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                //even numbers
                queue1.add(r.nextInt(50)*2);
            }
        }).start();

        //Thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                //odd numbers
                queue2.add(r.nextInt(50)*2 + 1);
            }
        }).start();
    }
}, 0, 2000);

//Main thread (maybe GUI)
while (true){
    while (!queue1.isEmpty()){
        System.out.println("Thread-1: " + queue1.poll());
    }
    while (!queue2.isEmpty()){
        System.out.println("Thread-2: " + queue2.poll());
    }
}