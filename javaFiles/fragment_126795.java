public class RunnerFirstAction implements Runnable {
    private Runner runner;
    public RunnerFirstAction(Runner runner) {
        this.runner = runner;
    }
    @Override
    public void run() {
        runner.first();
    }
}

public class RunnerSecondAction implements Runnable {
    private Runner runner;
    public RunnerSecondAction(Runner runner) {
        this.runner = runner;
    }
    @Override
    public void run() {
        runner.second();
    }
}


public class Main{

    static Runner r1 =new Runner();
    public static void main(String[] args) {
        Thread t1 = new Thread (new RunnerFirstAction(runner));
        Thread t2 = new Thread (new RunnerSecondAction(runner));
        //....
    }
}