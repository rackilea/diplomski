@Override
public void run() {
// A Consumer keeps taking elements from the queue 1, as long as the Producer is
// producing and as long as queue 1 is not empty.
    while (true) {
        try {

            //Retrieve the lines
            String line = firstBlockingQueue.take(); 
If a special terminating value is found.
            if (line==POISON_PILL) {
// The consumer notifies other consumers and the SignleConsumer that operates on queue 2
// and then terminates.
                firstBlockingQueue.put(POISON_PILL);
                secondBlockingQueue.put(SINGLE_POISIN_PILL);
                return;
            }
            // Put the normalized events on the new Queue
            String result = doNormalize (line);
            if (result!=null) {
                secondBlockingQueue.put(result);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}