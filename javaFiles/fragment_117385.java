public class Main {

    public static void main(String[] args) {
        int N=2;
        int M=3;

        Monitor m = new Monitor(N);

        Generator g = new Generator(m);
        g.start();

        Avg[] avg = new Avg[N];
        for (int i=0; i<N; i++){
            avg[i]=new Avg(i, m, M);
            avg[i].start();
        }
    }
}

class Generator extends Thread {
    private final Monitor m;

    public Generator(Monitor m) {
        this.m = m;
    }

    @Override
    public void run() {
        int i= 0;
        try {
            do {
                m.doWrite(i);
                ++i;
                Thread.sleep(500);
            } while (true);
        } catch (InterruptedException ie) {
        }
    }
}

class Avg extends Thread {
    private final int id;
    private final Monitor m;
    private final int M;

    public Avg(int id, Monitor m, int M) {
        this.id = id;
        this.m = m;
        this.M = M;
    }

    @Override
    public void run() {
        try {
            do {
                double sum = 0;
                for (int i = 0; i < M; ++i) {
                    sum += m.doRead(id);
                }
                double avg = sum / M;
                System.out.println("Avg " + id + " : " + avg);
            } while (true);
        } catch (InterruptedException ie) {
        }
    }
}

class Monitor { 
    private final Integer[] numbers;
    private int current;

    public Monitor(int N) {
        numbers = new Integer[N];
    }

    public synchronized void doWrite(int i) throws InterruptedException{
        while (numbers[current] != null) {
            wait();
        }
        numbers[current]=i;
        current = (current+1)%numbers.length;
        notifyAll();
    }

    public synchronized int doRead(int id) throws InterruptedException{                
        while (numbers[id] == null) {
            wait();
        }
        int result = numbers[id];
        numbers[id] = null;
        notifyAll();
        return result;
    }
}