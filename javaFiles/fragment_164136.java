public static final ArrayBlockingQueue<String> messages = new ArrayBlockingQueue<>(100);
public static final AtomicBoolean keepRunning = new AtomicBoolean(true);
.....
new Thread(new Runnable(){
    public void run(){
        while(keepRunning.get()){
            String message = messages.take();// blocks until a message is avaiable
            synchronized(Thread.currentThread()){
                Thread.currentThread().wait(3000);// pause 3 seconds before starting to process the next message.
            }
        }
    }
}).start();

// add messages from some other class;
MessagesProcessor.messages.add("some message");