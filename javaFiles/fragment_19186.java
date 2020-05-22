private static volatile int token = 0;

@Override
public void run() {

    for (int i = this.startIdx; i < this.maxIdx; i += this.nThreads) {

        while((token) % 3 != startIdx) Thread.yield();

        System.out.println("[ID " + this.getId() + "] " + i);
        token++;
    }

}