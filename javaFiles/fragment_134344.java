class WriteThread extends Thread {

    private BlockingQueue<Integer> createdIntegers;
    private BlockingQueue<Integer> processedIntegers;

    public WriteThread(BlockingQueue<? extends Integer> createdIntegers, BlockingQueue<? extends Integer> processedIntegers){
        this.createdIntegers = createdIntegers;
        this.processedIntegers = processedIntegers;
    }

    private boolean going = true;
    public void stopReadingAndWriting(){
        going = false;
        interrupt();
    }
    public void run(){
        while(going){
            try {
                createdIntegers.put(generateRandomInteger());
                System.out.println(processedIntegers.take());
            } catch (InterruptedException ie){
                // stop-in-the-middle handling code goes here
            }
        }
    }
}

class CalculationThread extends Thread {

    private BlockingQueue<Integer> createdIntegers;
    private BlockingQueue<Integer> processedIntegers;

    public CalculationThread(BlockingQueue<? extends Integer> createdIntegers, BlockingQueue<? extends Integer> processedIntegers){
        this.createdIntegers = createdIntegers;
        this.processedIntegers = processedIntegers;
    }

    private boolean going = true;
    public void stopReadingAndWriting(){
        going = false;
        interrupt();
    }

    public void run(){
        while(going){
            try {
                Integer integer = createdIntegers.take();
                integer = performCalculation(integer);
                processedIntegers.put(integer);
            } catch (InterruptedException ie){
                // stop-in-the-middle handling code goes here
            }
        }
    }
}