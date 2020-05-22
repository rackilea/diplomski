public final int MAX;
public int current = 1;
public int itemsInALine = 1;

Printer(int max) {
    this.MAX = max;
}

public void printNumber() {
    synchronized(this) {
        for(int i = current; i < current + itemsInALine && i <= MAX; i++) {
            System.out.print(i + " ");
        }
        this.current = current + itemsInALine;
        itemsInALine++;
        notifyAll();
        try {
            if(this.current < MAX) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public void printNewLine() {
    synchronized(this) {
        System.out.println();
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}